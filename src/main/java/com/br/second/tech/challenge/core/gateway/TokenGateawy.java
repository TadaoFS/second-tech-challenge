package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenGateawy {

    String generateToken(Usuario usuario);

    boolean validarToken(String token, Usuario userDetails);

    String extrairLogin(String token);
}
