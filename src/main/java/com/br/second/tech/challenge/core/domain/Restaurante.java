package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.database.entity.CardapioEntity;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.util.List;

public record Restaurante (
        Long id,
        String nome,
        String tipoCozinha,
        SemanaFuncionamento semanaFuncionamento,
        Usuario usuario,
        Endereco endereco,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public Restaurante(Long id, String nome, String tipoCozinha, Endereco endereco, SemanaFuncionamento semanaFuncionamento, Usuario usuario, LocalDateTime dataCriacao) {
        this(id, nome, tipoCozinha, semanaFuncionamento, usuario, endereco, dataCriacao, null );
    }
}
