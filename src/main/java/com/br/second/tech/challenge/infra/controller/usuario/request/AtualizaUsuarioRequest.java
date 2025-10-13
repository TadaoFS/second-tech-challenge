package com.br.second.tech.challenge.infra.controller.usuario.request;

import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AtualizaUsuarioRequest(
        @NotNull(message = "campo id obrigatorio")
        Long id,
        @NotEmpty(message = "campo nome obrigatorio")
        String nome,
        @NotEmpty(message = "campo email obrigatorio")
        String email,
        @NotEmpty(message = "campo login obrigatorio")
        String login,
        @NotNull(message = "campo endereco obrigatorio")
        EnderecoRequest endereco
) {
}
