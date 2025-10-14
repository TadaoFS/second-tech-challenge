package com.br.second.tech.challenge.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record Restaurante(
        Long id,
        String nome,
        String tipoCozinha,
        HorarioFuncionamento horarioFuncionamento,
        Usuario usuario,
        Endereco endereco,
        List<Prato> cardapio,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public Restaurante(Long id, String nome, String tipoCozinha, HorarioFuncionamento horarioFuncionamento, Long idUsuario, Endereco endereco) {
        this(id, nome, tipoCozinha, horarioFuncionamento, new Usuario(idUsuario), endereco, null, null, null);
    }

    public Restaurante(String nome, String tipoCozinha, HorarioFuncionamento horarioFuncionamento, Long idDonoRestaurante, Endereco endereco) {
        this(null, nome, tipoCozinha, horarioFuncionamento, new Usuario(idDonoRestaurante), endereco, null, null, null);
    }

    public Restaurante(Long id, String nome, String tipoCozinha, HorarioFuncionamento domain, Usuario domain1, Endereco domain2, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this(id, nome, tipoCozinha, domain, domain1, domain2, null, dataCriacao, dataAtualizacao);
    }

    public Restaurante(Long idRestaurante) {
        this(idRestaurante,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Restaurante criar(LocalDateTime localDateTime, Usuario usuario) {
        return new Restaurante(
                this.id,
                this.nome,
                this.tipoCozinha,
                this.horarioFuncionamento.comDataCriacao(localDateTime),
                usuario,
                this.endereco,
                new ArrayList<>(),
                localDateTime,
                localDateTime
        );
    }

    public Restaurante atualiza(Usuario usuario, LocalDateTime localDateTime) {
        return new Restaurante(
                this.id,
                this.nome,
                this.tipoCozinha,
                this.horarioFuncionamento,
                usuario,
                this.endereco,
                null,
                this.dataCriacao,
                localDateTime
        );
    }

    public Restaurante comHorarioFuncionamento(HorarioFuncionamento horarioFuncionamento) {
        return new Restaurante(
                this.id,
                this.nome,
                this.tipoCozinha,
                horarioFuncionamento,
                this.usuario,
                this.endereco,
                null,
                this.dataCriacao,
                this.dataAtualizacao
        );
    }

    public Restaurante atualizaPrato(List<Prato> pratosCompletos) {
        return new Restaurante(
                this.id,
                this.nome,
                this.tipoCozinha,
                this.horarioFuncionamento,
                this.usuario,
                this.endereco,
                pratosCompletos,
                this.dataCriacao,
                this.dataAtualizacao
        );
    }
}
