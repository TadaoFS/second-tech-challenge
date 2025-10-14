package com.br.second.tech.challenge.infra.controller.restaurante.request;

public record HorarioFuncionamentoRequest(
        HorarioUnidadeUpdateRequest segunda,
        HorarioUnidadeUpdateRequest terca,
        HorarioUnidadeUpdateRequest quarta,
        HorarioUnidadeUpdateRequest quinta,
        HorarioUnidadeUpdateRequest sexta,
        HorarioUnidadeUpdateRequest sabado,
        HorarioUnidadeUpdateRequest domingo
) {
}
