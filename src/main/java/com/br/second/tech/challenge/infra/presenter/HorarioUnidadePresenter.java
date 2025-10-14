package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.HorarioUnidade;
import com.br.second.tech.challenge.infra.controller.restaurante.request.HorarioUnidadeUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.HorarioUnidadeResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.model.HorarioUnidadeModel;

public class HorarioUnidadePresenter {

    public static HorarioUnidade toDomain(HorarioUnidadeModel horario) {
        if (horario == null) return null;
        return new HorarioUnidade(
                horario.getAberto(),
                horario.getHorarioAbertura(),
                horario.getHorarioFechamento()
        );
    }

    public static HorarioUnidade toDomain(HorarioUnidadeUpdateRequest horarioUnidadeUpdateRequest) {
        if (horarioUnidadeUpdateRequest == null) return null;
        return new HorarioUnidade(
                horarioUnidadeUpdateRequest.aberto(),
                horarioUnidadeUpdateRequest.horarioAbertura(),
                horarioUnidadeUpdateRequest.horarioFechamento()
        );
    }

    public static HorarioUnidadeResponse toResponse(HorarioUnidade result) {
        return new HorarioUnidadeResponse(
                result.aberto(),
                result.horarioAbertura(),
                result.horarioFechamento()
        );
    }

    public static HorarioUnidadeModel toModel(HorarioUnidade dia) {
        return HorarioUnidadeModel.builder()
                .aberto(dia.aberto())
                .horarioAbertura(dia.horarioAbertura())
                .horarioFechamento(dia.horarioFechamento())
                .build();
    }
}
