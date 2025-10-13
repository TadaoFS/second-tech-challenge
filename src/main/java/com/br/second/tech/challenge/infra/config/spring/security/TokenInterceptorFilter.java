package com.br.second.tech.challenge.infra.config.spring.security;

import com.br.second.tech.challenge.core.gateway.TokenGateawy;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.infra.presenter.UsuarioPresenter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenInterceptorFilter extends OncePerRequestFilter {

    private final TokenGateawy tokenGateawy;
    private final UsuarioGateway usuarioGateway;

    public TokenInterceptorFilter(TokenGateawy tokenGateawy, UsuarioGateway usuarioGateway) {
        this.tokenGateawy = tokenGateawy;
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        final String token;
        String username;

        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        username = tokenGateawy.extrairLogin(token);
        var usuarioOp = usuarioGateway.obterPorLogin(username);
        usuarioOp.ifPresent(
                usuario -> {
                    var details = UsuarioPresenter.toUserDetails(usuario);
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        if (tokenGateawy.validarToken(token, usuario)) {
                            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                    usuario, null, details.getAuthorities());
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                        }
                    }
                }
        );

        filterChain.doFilter(request, response);
    }
}
