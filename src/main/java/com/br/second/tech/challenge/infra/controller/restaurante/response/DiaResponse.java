package com.br.second.tech.challenge.infra.controller.restaurante.response;

import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDateTime;

public record DiaResponse(
        Dias nome,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
