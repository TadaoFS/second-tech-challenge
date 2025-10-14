package com.br.second.tech.challenge.core.domain;



import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDateTime;


public record HorarioFuncionamento(
        Long id,
        HorarioUnidade segunda,
        HorarioUnidade terca,
        HorarioUnidade quarta,
        HorarioUnidade quinta,
        HorarioUnidade sexta,
        HorarioUnidade sabado,
        HorarioUnidade domingo,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public HorarioFuncionamento comDataCriacao(LocalDateTime localDateTime) {
        return new HorarioFuncionamento(
                this.id,
                this.segunda,
                this.terca,
                this.quarta,
                this.quinta,
                this.sexta,
                this.sabado,
                this.domingo,
                localDateTime,
                localDateTime
        );
    }

    public HorarioFuncionamento atualizaDia(HorarioUnidade dia, LocalDateTime hAtualizacao, Dias diaSemana) {
        return new HorarioFuncionamento(
                this.id,
                Dias.SEGUNDA.equals(diaSemana) ? dia : this.segunda,
                Dias.TERCA.equals(diaSemana) ? dia : this.terca,
                Dias.QUARTA.equals(diaSemana) ? dia : this.quarta,
                Dias.QUINTA.equals(diaSemana) ? dia : this.quinta,
                Dias.SEXTA.equals(diaSemana) ? dia : this.sexta,
                Dias.SABADO.equals(diaSemana) ? dia : this.sabado,
                Dias.DOMINGO.equals(diaSemana) ? dia : this.domingo,
                hAtualizacao,
                hAtualizacao
        );
    }

    public HorarioUnidade obterDia(Dias dia) {
        return switch (dia){
            case SEGUNDA -> this.segunda;
            case TERCA -> this.terca;
            case QUARTA -> this.quarta;
            case QUINTA -> this.quinta;
            case SEXTA -> this.sexta;
            case SABADO -> this.sabado;
            case DOMINGO -> this.domingo;
        };
    }
}
