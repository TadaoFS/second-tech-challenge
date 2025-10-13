package com.br.second.tech.challenge.core.usecase.auth;

import com.br.second.tech.challenge.core.exception.AutorizacaoLoginErro;
import com.br.second.tech.challenge.core.gateway.AutorizacaoGateway;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.TokenGateawy;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RealizaLoginUsecase {

    private final EncriptadorGateway encriptadorGateway;
    private final TokenGateawy tokenGateawy;
    private final UsuarioGateway usuarioGateway;

    public RealizaLoginUsecase(EncriptadorGateway encriptadorGateway, TokenGateawy tokenGateawy, UsuarioGateway usuarioGateway) {
        this.encriptadorGateway = encriptadorGateway;
        this.tokenGateawy = tokenGateawy;
        this.usuarioGateway = usuarioGateway;
    }

    public String execute(String login, String senha) {
        log.info("[RealizaLoginUsecase.execute]: {} {}", login, senha);
        var usuario = usuarioGateway.obterPorLogin(login);
        if(usuario.isPresent()){
            var usuarioDomain = usuario.get();
            if(!encriptadorGateway.validarSenha(senha, usuarioDomain.senha())){
                log.error("[RealizaLoginUsecase.execute] - Senha invalida: {}", login);
                throw new AutorizacaoLoginErro("Senha invalida");
            }
            var token = tokenGateawy.generateToken(usuarioDomain);
            log.info("[RealizaLoginUsecase.execute] - Login realizado com sucesso: {}", login);
            return token;
        }
        log.error("[RealizaLoginUsecase.execute] - Usuario nao encontrado: {}", login);
        throw new AutorizacaoLoginErro("Login {} falhou".replace("{}", login));
    }
}
