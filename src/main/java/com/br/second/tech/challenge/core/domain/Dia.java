package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDateTime;

public record Dia (
        Long id,
        Dias nome,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {

    public Dia(Long id, Dias dias, boolean aberto, String horarioAbertura, String horarioFechamento) {
        this(id, dias, aberto, horarioAbertura, horarioFechamento, null, null);
    }

    public Dia(Dias nome, Boolean aberto, String horarioAbertura, String horarioFechamento) {
        this(null, nome, aberto, horarioAbertura, horarioFechamento);
    }

    public Dia(Boolean aberto, String horarioAbertura, String horarioFechamento) {
        this(null, null, aberto, horarioAbertura, horarioFechamento);
    }

    public Dia comData(LocalDateTime localDateTime) {
        return new Dia(
                this.id,
                this.nome,
                this.aberto,
                this.horarioAbertura,
                this.horarioFechamento,
                localDateTime,
                localDateTime
        );
    }

    public Dia atualiza(Dia dia, LocalDateTime dataAtualizacao) {
        return new Dia(
                this.id,
                this.nome,
                dia.aberto,
                dia.horarioAbertura,
                dia.horarioFechamento,
                this.dataCriacao,
                dataAtualizacao
        );
    }
}
