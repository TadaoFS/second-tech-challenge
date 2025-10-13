package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.enums.Dias;

public class DiaStub {


    public static Dia criaDiaFuncionamento(Dias dias) {
        return new Dia(
                dias,
                Boolean.TRUE,
                "12:00",
                "23:00"
        );
    }
}
