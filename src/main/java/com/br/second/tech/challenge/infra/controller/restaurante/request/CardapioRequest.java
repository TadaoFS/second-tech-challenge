package com.br.second.tech.challenge.infra.controller.restaurante.request;

import java.util.List;

public record CardapioRequest(
        List<PratoRequest> cardapio
) {
}
