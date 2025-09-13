package com.br.second.tech.challenge.infra.controller.dto;

import com.br.second.tech.challenge.infra.database.entity.CardapioEntity;
import com.br.second.tech.challenge.infra.database.entity.DiaFuncionamentoEntity;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.util.List;

public record RestauranteDTO(
        Long id,
        String nome,
        String tipoCozinha,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        List<DiaFuncionamentoEntity> diasFuncionamento, //TODO: Alterar para DiaFuncionamentoDTO
        UsuarioEntity usuario,
        List<CardapioEntity> cardapioEntities, //TODO: Alterar para CardapioDTO
        EnderecoEntity enderecoEntity //TODO: Alterar para EnderecoDTO
) {}