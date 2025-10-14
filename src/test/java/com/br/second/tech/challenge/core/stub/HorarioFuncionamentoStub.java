package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.HorarioFuncionamento;
import com.br.second.tech.challenge.infra.config.ClockStub;

public class HorarioFuncionamentoStub {

    public static HorarioFuncionamento criaHorarioFuncionamentoPadrao() {
        return new HorarioFuncionamento(
                1L,
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                HorarioUnidadeStub.criaDiaFuncionamento(),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }
}
