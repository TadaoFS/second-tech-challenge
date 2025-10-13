package com.br.second.tech.challenge.infra.gateway.spring.security;

import com.br.second.tech.challenge.core.gateway.AutorizacaoGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AutorizacaoSpringSecurityGateway implements AutorizacaoGateway {


    @Override
    public Boolean validarLogin(String login, String senha) {
        return Boolean.TRUE;
    }
}
