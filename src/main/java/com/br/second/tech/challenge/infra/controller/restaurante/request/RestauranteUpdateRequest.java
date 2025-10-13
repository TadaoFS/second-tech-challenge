package com.br.second.tech.challenge.infra.controller.restaurante.request;

import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RestauranteUpdateRequest(
        @NotNull(message = "Id do restaurante é obrigatório")
        Long id,
        @NotEmpty(message = "Nome do restaurante é obrigatório")
        String nome,
        @NotEmpty(message = "Tipo de cozinha é obrigatório")
        String tipoCozinha,
        @NotNull(message = "Id do dono do restaurante é obrigatório")
        Long idDonoRestaurante,
        @NotNull(message = "Endereço do restaurante é obrigatório")
        EnderecoRequest endereco
) {
}
