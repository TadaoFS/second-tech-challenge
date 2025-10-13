package com.br.second.tech.challenge.core.domain;

import java.time.LocalDateTime;

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
    public Restaurante(Long id, String nome, String tipoCozinha, SemanaFuncionamento horarioFuncionamento, Long idUsuario, Endereco endereco) {
        this(id, nome, tipoCozinha, horarioFuncionamento, new Usuario(idUsuario), endereco, null, null);
    }

    public Restaurante(String nome, String tipoCozinha, SemanaFuncionamento semanaFuncionamento, Long idDonoRestaurante, Endereco endereco) {
        this(null, nome, tipoCozinha, semanaFuncionamento, new Usuario(idDonoRestaurante), endereco, null, null);
    }
}
