package com.br.second.tech.challenge.infra.controller.tipousuario;

import com.br.second.tech.challenge.core.usecase.tipousuario.AlteraTipoUsuarioUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tipo-usuario")
@Slf4j
public class TipoUsuarioController {

    private final AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase;

    public TipoUsuarioController(AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase) {
        this.alteraTipoUsuarioUsecase = alteraTipoUsuarioUsecase;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/{idUsuario}/novo-tipo/{tipoUsuario}")
    public void alteraTipoUsuario(@PathVariable Long idUsuario, @PathVariable String tipoUsuario) {
        log.info("[TipoUsuarioController] - Alterando tipo do usuario: [ {} ] para [ {} ]", idUsuario, tipoUsuario);
        alteraTipoUsuarioUsecase.executar(idUsuario, tipoUsuario);
    }
}
