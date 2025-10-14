package com.br.second.tech.challenge.infra.controller.restaurante.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record HorarioFuncionamentoResponse(
        Long id,
        HorarioUnidadeResponse segunda,
        HorarioUnidadeResponse terca,
        HorarioUnidadeResponse quarta,
        HorarioUnidadeResponse quinta,
        HorarioUnidadeResponse sexta,
        HorarioUnidadeResponse sabado,
        HorarioUnidadeResponse domingo,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
