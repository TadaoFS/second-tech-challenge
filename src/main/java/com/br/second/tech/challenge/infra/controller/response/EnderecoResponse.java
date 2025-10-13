package com.br.second.tech.challenge.infra.controller.response;


import java.time.LocalDateTime;

public record EnderecoResponse (
        Long id,
        String cep,
        String logradouro,
        Long numero,
        String bairro,
        String cidade,
        String estado,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
){
}
