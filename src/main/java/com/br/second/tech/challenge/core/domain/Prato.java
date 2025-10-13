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
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
