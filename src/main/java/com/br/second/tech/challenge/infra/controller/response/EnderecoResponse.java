package com.br.second.tech.challenge.infra.controller.response;


public record EnderecoResponse (
        Long id,
        String cep,
        String logradouro,
        Long numero,
        String bairro,
        String cidade,
        String estado
){
}
