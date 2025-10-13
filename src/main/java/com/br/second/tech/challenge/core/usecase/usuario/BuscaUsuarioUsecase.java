package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BuscaUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;

    public BuscaUsuarioUsecase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Optional<Usuario> executar(Long id){
        log.info("[BuscaUsuarioUSecase.executar]: {}", id);
        var result = usuarioGateway.obterPorId(id);
        if(result.isEmpty()){
            log.error("[BuscaUsuarioUSecase.executar] - Usuário não encontrado com id: {}", id);
            throw new UsuarioNotFound("Usuário não encontrado com id: " + id);
        }
        log.info("[BuscaUsuarioUSecase.executar] - id {} encontrado", id);
        return result;
    }
}
