package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.infra.config.spring.security.UserSpringSec;
import com.br.second.tech.challenge.infra.controller.usuario.request.AtualizaUsuarioRequest;
import com.br.second.tech.challenge.infra.controller.usuario.request.CriarUsuarioRequest;
import com.br.second.tech.challenge.infra.controller.usuario.response.UsuarioResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.UsuarioEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;
import java.util.Optional;

public class UsuarioPresenter {

    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.id(),
                usuario.email(),
                usuario.nome(),
                usuario.login(),
                EnderecoPresenter.toRespone(Objects.isNull(usuario.endereco()) ? null : usuario.endereco()),
                usuario.tipoUsuario(),
                usuario.dataCriacao(),
                usuario.dataAtualizacao()
        );
    }

    public static Usuario toDomain(UsuarioEntity usuario) {
        return new Usuario(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getSenha(),
                Optional.ofNullable(usuario.getEndereco())
                        .map(EnderecoPresenter::toDomain)
                        .orElse(null),
                usuario.getTipoUsuario(),
                usuario.getDataCriacao(),
                usuario.getDataAtualizacao()
        );
    }

    public static Usuario toDomain(CriarUsuarioRequest usuarioReq) {
        return new Usuario(
                usuarioReq.email(),
                usuarioReq.nome(),
                usuarioReq.login(),
                usuarioReq.senha(),
                EnderecoPresenter.toDomain(usuarioReq.endereco())
        );
    }

    public static Usuario toDomain(AtualizaUsuarioRequest usuarioReq) {
        return new Usuario(
                usuarioReq.id(),
                usuarioReq.email(),
                usuarioReq.nome(),
                usuarioReq.login(),
                EnderecoPresenter.toDomain(usuarioReq.endereco())
        );
    }

    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                Objects.isNull(usuario.id()) ? null : usuario.id(),
                usuario.nome(),
                usuario.email(),
                usuario.login(),
                usuario.senha(),
                usuario.tipoUsuario(),
                EnderecoPresenter.toEntity(usuario.endereco()),
                usuario.dataCriacao(),
                usuario.dataAtualizacao()
        );
    }

    public static UserDetails toUserDetails(Usuario usuario) {
        return new UserSpringSec(
                usuario.login(),
                usuario.senha(),
                usuario.tipoUsuario()
        );
    }

    public static Usuario toDomain(UserDetails userDetails) {
        return new Usuario(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities().stream().findFirst().orElseThrow().getAuthority()
        );
    }
}
