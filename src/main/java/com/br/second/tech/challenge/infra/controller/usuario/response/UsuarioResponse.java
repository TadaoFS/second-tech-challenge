package com.br.second.tech.challenge.infra.controller.usuario.response;

import com.br.second.tech.challenge.core.enums.TipoUsuario;
import com.br.second.tech.challenge.infra.controller.response.EnderecoResponse;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String email,
        String nome,
        String login,
        EnderecoResponse endereco,
        TipoUsuario tipoUsuario,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {

}
