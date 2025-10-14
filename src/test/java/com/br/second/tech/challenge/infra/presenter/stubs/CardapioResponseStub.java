package com.br.second.tech.challenge.infra.presenter.stubs;

import com.br.second.tech.challenge.infra.controller.restaurante.response.CardapioResponse;

import java.util.List;

public class CardapioResponseStub {

    public static CardapioResponse criaStubEsperado() {
        return new CardapioResponse(List.of(PratoResponseStub.criaStub()));
    }
}
