package com.br.second.tech.challenge.infra.controller.restaurante.response;

import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DiaResponse(
        Long id,
        Dias nome,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento,
        LocalDate dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
