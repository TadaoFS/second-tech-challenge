package com.br.second.tech.challenge.infra.controller.tipousuario.request;

import jakarta.validation.constraints.NotNull;

public record TipoUsuarioRequest(
        @NotNull(message = "O id do usuário não pode ser nulo")
        Long idUsuario,
        @NotNull(message = "O nome do tipo de usuário não pode ser nulo")
        String nomeDoTipo
) {
}
