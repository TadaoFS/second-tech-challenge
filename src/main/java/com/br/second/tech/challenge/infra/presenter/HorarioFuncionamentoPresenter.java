package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.HorarioFuncionamento;
import com.br.second.tech.challenge.infra.controller.restaurante.request.HorarioFuncionamentoRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.HorarioFuncionamentoResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.HorarioFuncionamentoEntity;

import java.util.Objects;

public class HorarioFuncionamentoPresenter {

    public static HorarioFuncionamento toDomain(HorarioFuncionamentoEntity horarioFuncionamentoEntity) {
        return new HorarioFuncionamento(
                horarioFuncionamentoEntity.getId(),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getSegunda()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getTerca()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getQuarta()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getQuinta()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getSexta()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getSabado()),
                DiaPresenter.toDomain(horarioFuncionamentoEntity.getDomingo()),
                horarioFuncionamentoEntity.getDataCriacao(),
                horarioFuncionamentoEntity.getDataAtualizacao()
        );
    }

    public static HorarioFuncionamento toDomain(HorarioFuncionamentoRequest horarioFuncionamentoRequest) {
        return new HorarioFuncionamento(
                DiaPresenter.toDomain(horarioFuncionamentoRequest.segunda()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.terca()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.quarta()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.quinta()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.sexta()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.sabado()),
                DiaPresenter.toDomain(horarioFuncionamentoRequest.domingo())
        );
    }

    public static HorarioFuncionamentoResponse toResponse(HorarioFuncionamento result) {
        if (result == null) return null;
        return new HorarioFuncionamentoResponse(
                result.id(),
                DiaPresenter.toResponse(result.segunda()),
                DiaPresenter.toResponse(result.terca()),
                DiaPresenter.toResponse(result.quarta()),
                DiaPresenter.toResponse(result.quinta()),
                DiaPresenter.toResponse(result.sexta()),
                DiaPresenter.toResponse(result.sabado()),
                DiaPresenter.toResponse(result.domingo()),
                result.dataCriacao(),
                result.dataAtualizacao()
        );
    }

    public static HorarioFuncionamentoEntity toEntity(HorarioFuncionamento horarioFuncionamento) {
        if (horarioFuncionamento == null) return null;
        return HorarioFuncionamentoEntity.builder()
                .id(Objects.isNull(horarioFuncionamento.id()) ? null : horarioFuncionamento.id())
                .segunda(DiaPresenter.toEntity(horarioFuncionamento.segunda()))
                .terca(DiaPresenter.toEntity(horarioFuncionamento.terca()))
                .quarta(DiaPresenter.toEntity(horarioFuncionamento.quarta()))
                .quinta(DiaPresenter.toEntity(horarioFuncionamento.quinta()))
                .sexta(DiaPresenter.toEntity(horarioFuncionamento.sexta()))
                .sabado(DiaPresenter.toEntity(horarioFuncionamento.sabado()))
                .domingo(DiaPresenter.toEntity(horarioFuncionamento.domingo()))
                .dataCriacao(horarioFuncionamento.dataCriacao())
                .dataAtualizacao(horarioFuncionamento.dataAtualizacao())
                .build();
    }
}
