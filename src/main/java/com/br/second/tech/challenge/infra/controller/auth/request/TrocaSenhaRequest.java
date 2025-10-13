package com.br.second.tech.challenge.infra.controller.auth.request;

import jakarta.validation.constraints.NotEmpty;

public record TrocaSenhaRequest(
        @NotEmpty(message = "campo login obrigatorio")
        String login,
        @NotEmpty(message = "campo senha antiga obrigatorio")
        String senhaAntiga,
        @NotEmpty(message = "campo senha nova obrigatorio")
        String senhaNova
) {
}
