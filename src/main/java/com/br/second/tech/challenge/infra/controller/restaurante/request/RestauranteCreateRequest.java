package com.br.second.tech.challenge.infra.controller.restaurante.request;

import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;

public record RestauranteCreateRequest(
        String nome,
        String tipoCozinha,
        SemanaFuncionamentoRequest horarioFuncionamento,
        Long idDonoRestaurante,
        EnderecoRequest endereco
        ) {
}
