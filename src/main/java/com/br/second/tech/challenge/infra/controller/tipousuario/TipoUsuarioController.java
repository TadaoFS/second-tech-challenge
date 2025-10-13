package com.br.second.tech.challenge.infra.controller.tipousuario;

import com.br.second.tech.challenge.core.usecase.tipousuario.AlteraTipoUsuarioUsecase;
import com.br.second.tech.challenge.infra.controller.tipousuario.request.TipoUsuarioRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tipo-usuario")
@Slf4j
public class TipoUsuarioController {

    private final AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase;

    public TipoUsuarioController(AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase) {
        this.alteraTipoUsuarioUsecase = alteraTipoUsuarioUsecase;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping
    public void alteraTipoUsuario(@RequestBody @Valid TipoUsuarioRequest request) {
        log.info("[TipoUsuarioController] - Alterando tipo do idDonoRestaurante: [ {} ] para [ {} ]", request.idUsuario(), request.nomeDoTipo());
        alteraTipoUsuarioUsecase.executar(request.idUsuario(), request.nomeDoTipo());
    }
}
