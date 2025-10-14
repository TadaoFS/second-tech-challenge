package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioNotFoundException;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.UsuarioRepository;
import com.br.second.tech.challenge.infra.presenter.EnderecoPresenter;
import com.br.second.tech.challenge.infra.presenter.UsuarioPresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UsuarioSpringDataGateway implements UsuarioGateway {

    private final EncriptadorGateway encriptadorGateway;
    private final UsuarioRepository repository;

    public UsuarioSpringDataGateway(EncriptadorGateway encriptadorGateway, UsuarioRepository repository) {
        this.encriptadorGateway = encriptadorGateway;
        this.repository = repository;
    }

    @Override
    public Usuario atualizaUsuario(Usuario usuario) {
        log.info("[UsuarioSpringDataGateway.atualizaUsuario] - Atualizando usuario: {}", usuario);
        var editUser = repository.findById(usuario.id());
        if(editUser.isPresent()){
            var entity = editUser.get();
            entity.setNome(usuario.nome());
            entity.setEmail(usuario.email());
            entity.setLogin(usuario.login());
            entity.setEndereco(EnderecoPresenter.toEntity(usuario.endereco()));
            entity.setDataAtualizacao(usuario.dataAtualizacao());
            var result = repository.save(entity);
            return UsuarioPresenter.toDomain(result);
        }
        log.error("[UsuarioSpringDataGateway.atualizaUsuario] - Usuario {} nao encontrado", usuario.id());
        throw new UsuarioNotFoundException("Usuario {id} nao encontrado".replace("{id}", String.valueOf(usuario.id())));
    }

    @Override
    public Optional<Usuario> obterPorId(Long id) {
        log.info("[UsuarioSpringDataGateway.obterPorId] - Obtendo usuario por id: {}", id);
        return repository.findById(id)
                .map(UsuarioPresenter::toDomain);
    }

    @Override
    public Usuario salvaUsuario(Usuario usuario) {
        log.info("[UsuarioSpringDataGateway.salvaUsuario] - Salvando usuario: {}", usuario);
        var entity = UsuarioPresenter.toEntity(usuario);
        var result = repository.save(entity);
        log.info("[UsuarioSpringDataGateway.salvaUsuario] - Usuario salvo com sucesso: {}", result.getId());
        return UsuarioPresenter.toDomain(result);
    }

    @Override
    public Optional<Usuario> obterPorLogin(String login) {
        log.info("[UsuarioSpringDataGateway.obterPorLogin] - Obtendo usuario por login: {}", login);
        return repository.findByLogin(login)
                .map(UsuarioPresenter::toDomain);
    }

    @Override
    public void removeUsuario(Long id) {
        log.info("[UsuarioSpringDataGateway.removeUsuario] - removendo usuario com id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public void alterarSenha(Long id, String novaSenha) {
        log.info("[UsuarioSpringDataGateway.alterarSenha] - Alterando senha do usuario: {}", id);
        var usuario = repository.findById(id);
        if(usuario.isPresent()){
            var hash = encriptadorGateway.encriptar(novaSenha);
            usuario.get().setSenha(hash);
            repository.save(usuario.get());
        }
    }

    @Override
    public Optional<Usuario> obterPorLoginOuEmail(String login, String email) {
        log.info("[UsuarioSpringDataGateway.obterPorLoginOuEmail] - Obtendo usuario por login: {} | email: {}", login, email);
        return repository.findByLoginOrEmail(login, email)
                .map(UsuarioPresenter::toDomain);
    }

    @Override
    public void alteraTipoUsuario(Usuario usuario) {
        var usuarioEntity = repository.findById(usuario.id());
        usuarioEntity.ifPresent(user ->{
                    user.setTipoUsuario(usuario.tipoUsuario());
                    user.setDataAtualizacao(usuario.dataAtualizacao());
                    repository.save(user);
        } );
        log.info("[UsuarioSpringDataGateway.alteraTipoUsuario] - Tipo de usuario alterado com sucesso para o usuario: {}", usuario.id());
    }
}





