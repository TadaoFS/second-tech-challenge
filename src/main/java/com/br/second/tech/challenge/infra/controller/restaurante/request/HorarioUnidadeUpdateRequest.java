package com.br.second.tech.challenge.infra.controller.restaurante.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record HorarioUnidadeUpdateRequest(
        @NotNull(message = "campo 'aberto' não pode ser nulo")
        Boolean aberto,
        @NotEmpty(message = "campo 'horarioAbertura' não pode ser vazio")
        String horarioAbertura,
        @NotEmpty(message = "campo 'horarioFechamento' não pode ser vazio")
        String horarioFechamento
) {
}
