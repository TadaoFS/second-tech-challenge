package com.br.second.tech.challenge.infra.controller.restaurante.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PratoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean apenasNoLocal,
        String fotoDoPrato,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
