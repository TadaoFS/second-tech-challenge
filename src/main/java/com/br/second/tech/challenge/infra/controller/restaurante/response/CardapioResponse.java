package com.br.second.tech.challenge.infra.controller.restaurante.response;

import java.util.List;

public record CardapioResponse(
        List<PratoResponse> cardapio
) {
}
