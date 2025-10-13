package com.br.second.tech.challenge.infra.controller.restaurante.response;

import com.br.second.tech.challenge.infra.controller.response.EnderecoResponse;
import com.br.second.tech.challenge.infra.controller.usuario.response.UsuarioResponse;

public record RestauranteResponse(
        Long id,
        String nome,
        String tipoCozinha,
        SemanaFuncionamentoResponse semanaFuncionamento,
        UsuarioResponse usuario,
        EnderecoResponse endereco
) {}