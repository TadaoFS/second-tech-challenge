package com.br.second.tech.challenge.core.usecase.tipousuario;

import com.br.second.tech.challenge.core.enums.TipoUsuario;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
@Slf4j
public class AlteraTipoUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;
    private final Clock clock;

    public AlteraTipoUsuarioUsecase(UsuarioGateway usuarioGateway, Clock clock) {
        this.usuarioGateway = usuarioGateway;
        this.clock = clock;
    }

    public void executar(Long id, String novoTipo) {
        log.info("[AlteraTipoUsuarioUsecase.executar]: Alterando tipo do usuario com id {}", id);
        var usuarioOp = usuarioGateway.obterPorId(id);
        var tipoUsuario = TipoUsuario.extract(novoTipo);
        if(usuarioOp.isPresent()) {
            var usuario = usuarioOp.get();
            usuarioGateway.atualizaUsuario(usuario.alteraTipo(tipoUsuario, clock));
            log.info("Tipo do usuário com ID {} alterado para {}", id, novoTipo);
        } else {
            log.error("Usuário com ID {} não encontrado", id);
            throw new UsuarioNotFound("Usuário não encontrado");
        }
    }
}
