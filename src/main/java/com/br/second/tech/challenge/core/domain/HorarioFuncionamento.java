package com.br.second.tech.challenge.core.domain;


import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDateTime;


public record HorarioFuncionamento(
        Long id,
        Dia segunda,
        Dia terca,
        Dia quarta,
        Dia quinta,
        Dia sexta,
        Dia sabado,
        Dia domingo,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
    public HorarioFuncionamento(Dia segunda, Dia terca, Dia quarta, Dia quinta, Dia sexta, Dia sabado, Dia domingo) {
        this(null, segunda, terca, quarta, quinta, sexta, sabado, domingo, null, null);
    }

    public HorarioFuncionamento comDataCriacao(LocalDateTime localDateTime) {
        return new HorarioFuncionamento(
                this.id,
                this.segunda.comData(localDateTime),
                this.terca.comData(localDateTime),
                this.quarta.comData(localDateTime),
                this.quinta.comData(localDateTime),
                this.sexta.comData(localDateTime),
                this.sabado.comData(localDateTime),
                this.domingo.comData(localDateTime),
                localDateTime,
                localDateTime
        );
    }

    public Dia obterDia(Dias dia) {
        return switch (dia) {
            case SEGUNDA -> this.segunda;
            case TERCA -> this.terca;
            case QUARTA -> this.quarta;
            case QUINTA -> this.quinta;
            case SEXTA -> this.sexta;
            case SABADO -> this.sabado;
            case DOMINGO -> this.domingo;
        };
    }

    public HorarioFuncionamento atualizaDia(Dia dia, LocalDateTime dataAtualizacao) {
        var diaAtualizado = switch (dia.nome()) {
            case SEGUNDA -> this.segunda.atualiza(dia, dataAtualizacao);
            case TERCA -> this.terca.atualiza(dia, dataAtualizacao);
            case QUARTA -> this.quarta.atualiza(dia, dataAtualizacao);
            case QUINTA -> this.quinta.atualiza(dia, dataAtualizacao);
            case SEXTA -> this.sexta.atualiza(dia, dataAtualizacao);
            case SABADO -> this.sabado.atualiza(dia, dataAtualizacao);
            case DOMINGO -> this.domingo.atualiza(dia, dataAtualizacao);
        };

        return new HorarioFuncionamento(
                this.id,
                Dias.SEGUNDA.equals(dia.nome()) ? diaAtualizado : this.segunda,
                Dias.TERCA.equals(dia.nome()) ? diaAtualizado : this.terca,
                Dias.QUARTA.equals(dia.nome()) ? diaAtualizado : this.quarta,
                Dias.QUINTA.equals(dia.nome()) ? diaAtualizado : this.quinta,
                Dias.SEXTA.equals(dia.nome()) ? diaAtualizado : this.sexta,
                Dias.SABADO.equals(dia.nome()) ? diaAtualizado : this.sabado,
                Dias.DOMINGO.equals(dia.nome()) ? diaAtualizado : this.domingo,
                this.dataCriacao,
                dataAtualizacao
        );
    }
}
