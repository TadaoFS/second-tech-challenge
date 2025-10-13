package com.br.second.tech.challenge.infra.gateway.spring.security;

import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncriptadorSpringSecurityGateway implements EncriptadorGateway {

    private final PasswordEncoder passwordEncoder;

    public EncriptadorSpringSecurityGateway(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encriptar(String senha) {
        return passwordEncoder.encode(senha);
    }

    @Override
    public Boolean validarSenha(String senha, String senhaEncriptada) {
        return passwordEncoder.matches(senha, senhaEncriptada);
    }
}
