package com.br.second.tech.challenge.infra.controller.restaurante.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record HorarioFuncionamentoResponse(
        Long id,
        DiaResponse segunda,
        DiaResponse terca,
        DiaResponse quarta,
        DiaResponse quinta,
        DiaResponse sexta,
        DiaResponse sabado,
        DiaResponse domingo,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
