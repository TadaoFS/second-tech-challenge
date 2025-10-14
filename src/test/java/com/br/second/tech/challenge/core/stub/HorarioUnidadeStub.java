package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.HorarioUnidade;

public class HorarioUnidadeStub {

    public static HorarioUnidade criaDiaFuncionamento() {
        return new HorarioUnidade(
                Boolean.TRUE,
                "12:00",
                "23:00"
        );
    }
}
