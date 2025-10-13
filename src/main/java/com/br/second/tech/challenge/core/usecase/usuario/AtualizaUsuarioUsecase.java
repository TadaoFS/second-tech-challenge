package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioExistenteException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AtualizaUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;

    public AtualizaUsuarioUsecase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario executar(Usuario usuario){
        log.info("[AtualiaUsuarioUsecase.executar]: editando usuario com id {}", usuario.id());
        var usuarioOp = usuarioGateway.obterPorId(usuario.id());
        var usuarioConflict = usuarioGateway.obterPorLoginOuEmail(usuario.login(), usuario.email());
        if(usuarioConflict.isPresent()){
            log.error("[AtualiaUsuarioUsecase.executar]: usuario com login ou email ja existente");
            throw new UsuarioExistenteException("Usuario com login ou email ja existente");
        }
        if(usuarioOp.isPresent()){
            return usuarioGateway.atualizaUsuario(usuario);
        }
        log.error("[AtualiaUsuarioUsecase.executar]: usuario {} nao encontrado", usuario.id());
        throw new UsuarioNotFound("Usuario {id} nao encontrado".replace("{id}", String.valueOf(usuario.id())));
    }
}
