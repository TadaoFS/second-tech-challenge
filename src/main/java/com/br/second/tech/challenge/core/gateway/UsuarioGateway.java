package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Usuario;

import java.util.Optional;

public interface UsuarioGateway {
    Usuario atualizaUsuario(Usuario usuario);
    Optional<Usuario> obterPorId(Long idUsuario);
    Usuario salvaUsuario(Usuario usuario);
    Optional<Usuario> obterPorLogin(String username);
    void removeUsuario(Long idUsuario);
    void alterarSenha(Long idUsuario, String novaSenha);
    Optional<Usuario> obterPorLoginOuEmail(String login, String email);
    void alteraTipoUsuario(Usuario usuario);
}
