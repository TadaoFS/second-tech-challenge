package com.br.second.tech.challenge.infra.controller.dto;

import lombok.Builder;

@Builder
public record SemanaFuncionamentoDTO(
        Long id,
        DiaDTO segunda,
        DiaDTO terca,
        DiaDTO quarta,
        DiaDTO quinta,
        DiaDTO sexta,
        DiaDTO sabado,
        DiaDTO domingo
) {
}
