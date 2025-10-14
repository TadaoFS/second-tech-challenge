package com.br.second.tech.challenge.infra.controller.auth.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "campo login obrigatorio")
        String login,
        @NotEmpty(message = "campo senha obrigatorio")
        String senha
) {
}
