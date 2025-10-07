package com.br.second.tech.challenge.infra.controller.dto;

import com.br.second.tech.challenge.infra.database.entity.CardapioEntity;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;

import java.util.List;

public record RestauranteDTO(
        Long id,
        String nome,
        String tipoCozinha,
        SemanaFuncionamentoDTO semanaFuncionamento,
        UsuarioEntity usuario,
        List<CardapioEntity> cardapioEntities,
        EnderecoEntity enderecoEntity
) {}