package com.br.second.tech.challenge.infra.controller.restaurante.request;

import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;

public record RestauranteUpdateRequest(
        Long id,
        String nome,
        String tipoCozinha,
        SemanaFuncionamentoRequest horarioFuncionamento,
        Long donoRestaurante,
        EnderecoRequest endereco
) {
}
