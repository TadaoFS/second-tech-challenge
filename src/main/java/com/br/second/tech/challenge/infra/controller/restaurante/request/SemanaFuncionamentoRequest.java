package com.br.second.tech.challenge.infra.controller.restaurante.request;

import java.time.LocalDateTime;

public record SemanaFuncionamentoRequest(
        DiaRequest segunda,
        DiaRequest terca,
        DiaRequest quarta,
        DiaRequest quinta,
        DiaRequest sexta,
        DiaRequest sabado,
        DiaRequest domingo,
        LocalDateTime clock
) {
}
