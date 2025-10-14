package com.br.second.tech.challenge.core.domain;

public record Endereco(
        Long id,
        String cep,
        String logradouro,
        Long numero,
        String bairro,
        String cidade,
        String estado
) {
    public Endereco(String cep, String logradouro, Long numero, String bairro, String cidade, String estado) {
        this(null, cep, logradouro, numero, bairro, cidade, estado);
    }
}
