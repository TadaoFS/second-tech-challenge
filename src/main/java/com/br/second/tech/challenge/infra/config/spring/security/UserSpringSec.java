package com.br.second.tech.challenge.infra.config.spring.security;

import com.br.second.tech.challenge.core.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserSpringSec implements UserDetails {

    private String username;
    private String pass;
    private List<GrantedAuthority> authorities;

    public UserSpringSec(String login, String senha, TipoUsuario tipoUsuario) {
        this.username = login;
        this.pass = senha;
        this.authorities = List.of(tipoUsuario::name);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
