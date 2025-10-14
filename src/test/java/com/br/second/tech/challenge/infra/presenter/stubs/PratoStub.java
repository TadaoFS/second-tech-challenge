package com.br.second.tech.challenge.infra.presenter.stubs;

import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.config.ClockStub;

import java.math.BigDecimal;

public class PratoStub {

    public static Prato criaPrato() {
        return new Prato(
                1L,
                "test",
                "descTest",
                BigDecimal.ONE,
                true,
                "foto",
                new Restaurante(1L),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }
}
