package com.br.second.tech.challenge.infra.controller.restaurante.request;

import com.br.second.tech.challenge.core.enums.Dias;

public record DiaRequest(
        Dias nome,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento
) {
}
