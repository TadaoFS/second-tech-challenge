package com.br.second.tech.challenge.infra.controller.usuario.request;

import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CriarUsuarioRequest(
        @NotEmpty(message = "campo nome obrigatorio")
        String nome,
        @NotEmpty(message = "campo email obrigatorio")
        String email,
        @NotEmpty(message = "campo login obrigatorio")
        String login,
        @NotEmpty(message = "campo senha obrigatorio")
        String senha,
        @NotNull(message = "campo endereco obrigatorio")
        EnderecoRequest endereco
) {
}
