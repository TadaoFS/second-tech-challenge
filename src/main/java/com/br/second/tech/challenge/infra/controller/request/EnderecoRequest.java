package com.br.second.tech.challenge.infra.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record EnderecoRequest(
        @NotEmpty(message = "campo cep obrigatorio")
        String cep,
        @NotEmpty(message = "campo logradouro obrigatorio")
        String logradouro,
        @NotEmpty(message = "campo numero obrigatorio")
        Long numero,
        @NotEmpty(message = "campo bairro obrigatorio")
        String bairro,
        @NotEmpty(message = "campo cidade obrigatorio")
        String cidade,
        @NotEmpty(message = "campo estado obrigatorio")
        String estado
) {
}
