package com.br.second.tech.challenge.infra.controller.auth.response;

public record LoginResponse(
        String suffix,
        String token
) {
}
