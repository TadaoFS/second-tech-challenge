package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioExistenteException;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CriaUsuarioUsecase {

    private final EncriptadorGateway encriptadorGateway;
    private final UsuarioGateway usuarioGateway;

    public CriaUsuarioUsecase(EncriptadorGateway encriptadorGateway, UsuarioGateway usuarioGateway) {
        this.encriptadorGateway = encriptadorGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario executar(Usuario usuario) {
        log.info("[CriaUsuarioUsecase.executar] - Criando usuario {}", usuario);
        var usuarioOp = usuarioGateway.obterPorLoginOuEmail(usuario.login(), usuario.email());
        if(usuarioOp.isPresent()){
            log.error("[CriaUsuarioUsecase.executar] - Usuario com login {} já existe.", usuario.login());
            throw new UsuarioExistenteException("Usuário com login " + usuario.login() + " já existe.");
        }
        var pass = encriptadorGateway.encriptar(usuario.senha());
        var result = usuarioGateway.salvaUsuario(usuario.gerarCliente(pass));
        log.info("[CriaUsuarioUsecase.executar] - Usuario criado com sucesso: {}", result.id());
        return result;
    }
}
