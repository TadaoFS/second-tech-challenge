package com.br.second.tech.challenge.infra.gateway.spring.security;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.gateway.TokenGateawy;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TokenSpringSecurityGateway implements TokenGateawy {

    @Value("${jwt.secret.key}")
    private String jwtKey;

    @Value("${jwt.expiration.time:3600}")
    private Long jwtExpiration;

    @Override
    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .subject(usuario.login())
                .claim("authorities", List.of(usuario.tipoUsuario().name()))
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.SECONDS)))
                .signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtKey)), Jwts.SIG.HS256)
                .compact();
    }

    @Override
    public boolean validarToken(String token, Usuario usuario) {
        try {
            var subject = Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtKey)))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
            return subject.equals(usuario.login());
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public String extrairLogin(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtKey)))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
