package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Dia (
        Long id,
        Dias nome,
        Boolean aberto,
        String horarioAbertura,
        String horarioFechamento,
        LocalDate dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public Dia(Long id, Dias dias, String horarioAbertura, String horarioFechamento){
        this(id, dias, Boolean.FALSE, horarioAbertura, horarioFechamento, LocalDate.now(), LocalDateTime.now());
    }

    public Dia(Long id, Dias dias, boolean aberto, String horarioAbertura, String horarioFechamento) {
        this(id, dias, aberto, horarioAbertura, horarioFechamento, LocalDate.now(), LocalDateTime.now());
    }


    public Dia(Dias nome, Boolean aberto, String horarioAbertura, String horarioFechamento) {
        this(null, nome, aberto, horarioAbertura, horarioFechamento);
    }
}
