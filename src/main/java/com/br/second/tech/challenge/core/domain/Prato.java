package com.br.second.tech.challenge.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Prato(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean apenasNoLocal,
        String fotoDoPrato,
        Restaurante restaurante,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public Prato(String nome,
                 String descricao,
                 BigDecimal preco,
                 Boolean apenasNoLocal,
                 String fotoDoPrato) {
        this(null, nome, descricao, preco, apenasNoLocal, fotoDoPrato, null, null, null);
    }

    public Prato(String nome,
                 String descricao,
                 BigDecimal preco,
                 Boolean apenasNoLocal,
                 String fotoDoPrato,
                 Long idRestaurante) {
        this(null, nome, descricao, preco, apenasNoLocal, fotoDoPrato, new Restaurante(idRestaurante), null, null);
    }

    public Prato(Long id, String nome, String descricao, BigDecimal preco, Boolean apenasNoLocal, String fotoDoPrato, Restaurante restaurante, LocalDateTime dataAtualizacao) {
        this(id, nome, descricao, preco, apenasNoLocal, fotoDoPrato, restaurante, null, dataAtualizacao);
    }

    public Prato(Long id, String nome, String descricao, BigDecimal preco, Boolean apenasNoLocal, String fotoDoPrato, Restaurante restaurante) {
        this(id, nome, descricao, preco, apenasNoLocal, fotoDoPrato, restaurante, null, null);
    }

    public Prato dataCriacao(LocalDateTime instante) {
        return new Prato(
                this.id,
                this.nome,
                this.descricao,
                this.preco,
                this.apenasNoLocal,
                this.fotoDoPrato,
                this.restaurante,
                instante,
                instante
        );
    }

    public Prato vinculaPrato(Long idRestaurante, LocalDateTime instante) {
        return new Prato(
                this.id,
                this.nome,
                this.descricao,
                this.preco,
                this.apenasNoLocal,
                this.fotoDoPrato,
                new Restaurante(idRestaurante),
                instante,
                instante
        );
    }

    public Prato atualizarPrato(LocalDateTime instante) {
        return new Prato(
                this.id,
                this.nome,
                this.descricao,
                this.preco,
                this.apenasNoLocal,
                this.fotoDoPrato,
                this.restaurante,
                this.dataCriacao,
                instante
        );
    }
}
