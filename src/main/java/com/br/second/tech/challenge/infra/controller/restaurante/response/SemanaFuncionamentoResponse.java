package com.br.second.tech.challenge.infra.controller.restaurante.response;

import lombok.Builder;

@Builder
public record SemanaFuncionamentoResponse(
        Long id,
        DiaResponse segunda,
        DiaResponse terca,
        DiaResponse quarta,
        DiaResponse quinta,
        DiaResponse sexta,
        DiaResponse sabado,
        DiaResponse domingo
) {
}
