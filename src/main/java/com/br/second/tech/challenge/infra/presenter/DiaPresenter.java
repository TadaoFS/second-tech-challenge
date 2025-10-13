package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.controller.restaurante.request.DiaRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.DiaResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.DiaEntity;

public class DiaPresenter {

    public static Dia toDomain(DiaEntity segunda) {
        if (segunda == null) return null;
        return new Dia(
                segunda.getId(),
                segunda.getNome(),
                segunda.getAberto(),
                segunda.getHorarioAbertura(),
                segunda.getHorarioFechamento()
        );
    }

    public static Dia toDomain(DiaRequest diaRequest) {
        if (diaRequest == null) return null;
        return new Dia(
                diaRequest.nome(),
                diaRequest.aberto(),
                diaRequest.horarioAbertura(),
                diaRequest.horarioFechamento()
        );
    }

    public static DiaResponse toResponse(Dia result) {
        return new DiaResponse(
                result.id(),
                result.nome(),
                result.aberto(),
                result.horarioAbertura(),
                result.horarioFechamento(),
                result.dataCriacao(),
                result.dataAtualizacao()
        );
    }
}
