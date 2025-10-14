package com.br.second.tech.challenge.infra.controller.restaurante.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PratoRequest(
        @NotEmpty(message = "campo nome obrigatorio")
        String nome,
        @NotEmpty(message = "campo descricao obrigatorio")
        String descricao,
        @NotNull(message = "campo preco obrigatorio")
        BigDecimal preco,
        @NotNull(message = "campo apenas no local obrigatorio")
        Boolean apenasNoLocal,
        @NotEmpty(message = "campo foto do prato obrigatorio")
        String fotoDoPrato
) {
}
