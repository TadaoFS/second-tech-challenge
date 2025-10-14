package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.infra.controller.restaurante.response.CardapioResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.PratoEntity;

import java.util.List;

public class CardapioPresenter {

    public static CardapioResponse toResponse(List<Prato> result) {
        return new CardapioResponse(PratoPresenter.toResponse(result));
    }

    public static List<Prato> toDomain(List<PratoEntity> cardapio) {
        return cardapio.stream().map(PratoPresenter::toDomain).toList();
    }
}
