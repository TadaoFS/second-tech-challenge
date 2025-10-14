package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.infra.presenter.stubs.CardapioResponseStub;
import com.br.second.tech.challenge.infra.presenter.stubs.PratoEntityStub;
import com.br.second.tech.challenge.infra.presenter.stubs.PratoStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardapioPresenterTest {


    @Test
    @DisplayName("Deve testar o metodo toResponse em CardapioPresenter")
    void testToResponse() {
        var responseExpected = CardapioResponseStub.criaStubEsperado();
        var pratoResponse = PratoStub.criaPrato();
        var obj = CardapioPresenter.toResponse(List.of(pratoResponse));
        assertEquals(responseExpected, obj);
    }

    @Test
    @DisplayName("Deve testar metodo toDomain em CardapioPresenter")
    void testToDomain(){
        var pratoExpected = PratoStub.criaPrato();
        var pratoEntity = PratoEntityStub.criaPrato();
    }

}