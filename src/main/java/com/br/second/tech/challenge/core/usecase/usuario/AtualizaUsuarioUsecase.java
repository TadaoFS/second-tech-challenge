package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioExistenteException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFoundException;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AtualizaUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;
    private final RelogioGateway relogioGateway;

    public AtualizaUsuarioUsecase(UsuarioGateway usuarioGateway, RelogioGateway relogioGateway) {
        this.usuarioGateway = usuarioGateway;
        this.relogioGateway = relogioGateway;
    }

    public Usuario executar(Usuario usuario){
        log.info("[AtualiaUsuarioUsecase.executar]: editando idDonoRestaurante com id {}", usuario.id());
        var usuarioOp = usuarioGateway.obterPorId(usuario.id());
        var usuarioConflict = usuarioGateway.obterPorLoginOuEmail(usuario.login(), usuario.email());
        if(usuarioConflict.isPresent()){
            log.error("[AtualiaUsuarioUsecase.executar]: idDonoRestaurante com login ou email ja existente");
            throw new UsuarioExistenteException("Usuario com login ou email ja existente");
        }
        if(usuarioOp.isPresent()){
            var usuarioAtualizado = usuario.dataAtualizacao(relogioGateway.registrarTempo());
            return usuarioGateway.atualizaUsuario(usuarioAtualizado);
        }
        log.error("[AtualiaUsuarioUsecase.executar]: idDonoRestaurante {} nao encontrado", usuario.id());
        throw new UsuarioNotFoundException("Usuario {id} nao encontrado".replace("{id}", String.valueOf(usuario.id())));
    }
}
