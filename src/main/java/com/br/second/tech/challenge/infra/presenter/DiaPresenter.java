package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.infra.controller.restaurante.request.DiaUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.DiaResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.DiaEntity;
import jakarta.validation.Valid;

import java.util.Objects;

public class DiaPresenter {

    public static Dia toDomain(DiaEntity dia) {
        if (dia == null) return null;
        return new Dia(
                dia.getId(),
                dia.getNome(),
                dia.getAberto(),
                dia.getHorarioAbertura(),
                dia.getHorarioFechamento(),
                dia.getDataCriacao(),
                dia.getDataAtualizacao()
        );
    }

    public static Dia toDomain(DiaUpdateRequest diaUpdateRequest) {
        if (diaUpdateRequest == null) return null;
        return new Dia(
                diaUpdateRequest.aberto(),
                diaUpdateRequest.horarioAbertura(),
                diaUpdateRequest.horarioFechamento()
        );
    }

    public static DiaResponse toResponse(Dia result) {
        return new DiaResponse(
                result.nome(),
                result.aberto(),
                result.horarioAbertura(),
                result.horarioFechamento(),
                result.dataCriacao(),
                result.dataAtualizacao()
        );
    }

    public static DiaEntity toEntity(Dia dia) {
        return DiaEntity.builder()
                .id(Objects.isNull(dia.id()) ? null : dia.id())
                .nome(dia.nome())
                .aberto(dia.aberto())
                .horarioAbertura(dia.horarioAbertura())
                .horarioFechamento(dia.horarioFechamento())
                .dataCriacao(dia.dataCriacao())
                .dataAtualizacao(dia.dataAtualizacao())
                .build();
    }

    public static Dia toDomain(@Valid DiaUpdateRequest diaUpdateRequest, Dias dia) {
        return new Dia(
                dia,
                diaUpdateRequest.aberto(),
                diaUpdateRequest.horarioAbertura(),
                diaUpdateRequest.horarioFechamento()
        );
    }
}
