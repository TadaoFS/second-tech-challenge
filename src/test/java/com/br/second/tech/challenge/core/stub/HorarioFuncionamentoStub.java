package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.HorarioFuncionamento;
import com.br.second.tech.challenge.core.enums.Dias;

public class HorarioFuncionamentoStub {

    public static HorarioFuncionamento criaHorarioFuncionamentoPadrao() {
        return new HorarioFuncionamento(
                DiaStub.criaDiaFuncionamento(Dias.SEGUNDA),
                DiaStub.criaDiaFuncionamento(Dias.TERCA),
                DiaStub.criaDiaFuncionamento(Dias.QUARTA),
                DiaStub.criaDiaFuncionamento(Dias.QUINTA),
                DiaStub.criaDiaFuncionamento(Dias.SEXTA),
                DiaStub.criaDiaFuncionamento(Dias.SABADO),
                DiaStub.criaDiaFuncionamento(Dias.DOMINGO)
        );
    }
}
