package com.br.second.tech.challenge.infra.controller.restaurante.response;

import com.br.second.tech.challenge.infra.controller.response.EnderecoResponse;

import java.time.LocalDateTime;

public record RestauranteResponse(
        Long id,
        String nome,
        String tipoCozinha,
        HorarioFuncionamentoResponse horarioFuncionamento,
        Long idDonoRestaurante,
        EnderecoResponse endereco,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {}