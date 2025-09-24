package com.br.second.tech.challenge.infra.controller.dto;

import com.br.second.tech.challenge.core.enums.Dias;

public record DiaDTO(
        Long id,
        Dias nome,
        boolean aberto,
        String horarioAbertura,
        String horarioFechamento
) {
}
