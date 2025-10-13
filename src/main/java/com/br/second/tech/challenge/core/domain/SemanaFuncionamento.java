package com.br.second.tech.challenge.core.domain;


import java.time.LocalDateTime;


public record SemanaFuncionamento(
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
    public SemanaFuncionamento(Dia segunda, Dia terca, Dia quarta, Dia quinta, Dia sexta, Dia sabado, Dia domingo) {
        this(null, segunda, terca, quarta, quinta, sexta, sabado, domingo, null, null);
    }
}
