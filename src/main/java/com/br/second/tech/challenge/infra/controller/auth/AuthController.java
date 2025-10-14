package com.br.second.tech.challenge.infra.controller.auth;

import com.br.second.tech.challenge.core.usecase.auth.RealizaLoginUsecase;
import com.br.second.tech.challenge.core.usecase.usuario.AlteraSenhaUsuarioUsecase;
import com.br.second.tech.challenge.infra.controller.auth.request.LoginRequest;
import com.br.second.tech.challenge.infra.controller.auth.request.TrocaSenhaRequest;
import com.br.second.tech.challenge.infra.controller.auth.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1/auth")
public class AuthController {

    private final RealizaLoginUsecase realizaLoginUsecase;
    private final AlteraSenhaUsuarioUsecase alteraSenhaUsuarioUsecase;
    private static final String SUFFIX_TOKEN = "Bearer";

    public AuthController(RealizaLoginUsecase realizaLoginUsecase, AlteraSenhaUsuarioUsecase alteraSenhaUsuarioUsecase) {
        this.realizaLoginUsecase = realizaLoginUsecase;
        this.alteraSenhaUsuarioUsecase = alteraSenhaUsuarioUsecase;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest req){
        log.info("[AuthController.login] - Realizando login: [ {} ]", req.login());
        var token = realizaLoginUsecase.execute(req.login(), req.senha());
        return new LoginResponse(SUFFIX_TOKEN, token);
    }

    @PatchMapping("/troca-senha")
    public void trocaSenha(@RequestBody @Valid TrocaSenhaRequest req){
        log.info("[AuthController.trocaSenha] - Alterando senha do idDonoRestaurante: [ {} ]", req.login());
        alteraSenhaUsuarioUsecase.executar(req.login(),req.senhaAntiga(), req.senhaNova());
    }
}
