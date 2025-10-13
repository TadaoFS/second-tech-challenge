package com.br.second.tech.challenge.infra.controller.restaurante.request;

public record HorarioFuncionamentoRequest(
        DiaUpdateRequest segunda,
        DiaUpdateRequest terca,
        DiaUpdateRequest quarta,
        DiaUpdateRequest quinta,
        DiaUpdateRequest sexta,
        DiaUpdateRequest sabado,
        DiaUpdateRequest domingo
) {
}
