package com.br.second.tech.challenge.infra.controller.restaurante.response;

public record HorarioUnidadeResponse(
       Boolean aberto,
       String horarioAbertura,
       String horarioFechamento
) {
}
