package com.br.second.tech.challenge.core.domain;

import java.time.LocalDateTime;

public record Endereco(
        Long id,
        String cep,
        String logradouro,
        Long numero,
        String bairro,
        String cidade,
        String estado,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public Endereco(String cep, String logradouro, Long numero, String bairro, String cidade, String estado) {
        this(null, cep, logradouro, numero, bairro, cidade, estado, null, null);
    }
}
