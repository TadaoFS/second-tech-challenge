package com.br.second.tech.challenge.infra.config.spring.security;

import com.br.second.tech.challenge.infra.gateway.spring.data.repository.UsuarioRepository;
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

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuarioOp = usuarioRepository.findByLogin(username);

        if(usuarioOp.isPresent()) {
            var usuario = usuarioOp.get();
            List<GrantedAuthority> autorizacoes = List.of(
                    new SimpleGrantedAuthority(usuario.getTipoUsuario().name())
            );
            return new UserSpringSec(username, usuario.getSenha(), autorizacoes);
        }

        log.warn("Usuário não encontrado com login informado: {}", username);
        throw new UsernameNotFoundException("Usuário não encontrado com login informado: " + username);
    }

}
