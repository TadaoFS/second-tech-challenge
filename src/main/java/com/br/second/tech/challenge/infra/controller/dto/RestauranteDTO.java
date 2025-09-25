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
        SemanaFuncionamentoDTO semanaFuncionamento, //TODO: Alterar para SemanaFuncionamentoDTO
        UsuarioEntity usuario,
        List<CardapioEntity> cardapioEntities, //TODO: Alterar para CardapioDTO
        EnderecoEntity enderecoEntity //TODO: Alterar para EnderecoDTO
) {}