package com.br.second.tech.challenge.infra.config.spring.security;

import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioGateway usuarioGateway;

    public UserDetailsServiceImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuarioOp = usuarioGateway.obterPorLogin(username);

        if(usuarioOp.isPresent()) {
            var usuario = usuarioOp.get();
            List<GrantedAuthority> autorizacoes = List.of(
                    new SimpleGrantedAuthority(usuario.tipoUsuario().name())
            );
            return new UserSpringSec(username, usuario.senha(), autorizacoes);
        }

        log.warn("Usuário não encontrado com username informado: {}", username);
        throw new UsernameNotFoundException("Usuário não encontrado com username informado: " + username);
    }

}
