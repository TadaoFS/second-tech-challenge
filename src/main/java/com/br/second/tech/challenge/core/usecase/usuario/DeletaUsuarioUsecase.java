package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeletaUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;

    public DeletaUsuarioUsecase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void executar(Long id){
        log.info("Deletando usuario com id {}", id);
        var result = usuarioGateway.obterPorId(id);
        if(result.isPresent()){
            usuarioGateway.removeUsuario(id);
        } else {
            log.error("Usuário não encontrado com id: {}", id);
            throw new UsuarioNotFound("Usuário não encontrado com id: " + id);
        }
    }
}
