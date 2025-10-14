package com.br.second.tech.challenge.infra.presenter.stubs;

import com.br.second.tech.challenge.infra.config.ClockStub;
import com.br.second.tech.challenge.infra.controller.restaurante.response.PratoResponse;

import java.math.BigDecimal;

public class PratoResponseStub {

    public static PratoResponse criaStub() {
        return new PratoResponse(
                1L,
                "test",
                "descTest",
                BigDecimal.ONE,
                true,
                "foto",
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }
}
