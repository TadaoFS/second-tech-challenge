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
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getSegunda()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getTerca()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getQuarta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getQuinta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getSexta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getSabado()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoEntity.getDomingo()),
                horarioFuncionamentoEntity.getDataCriacao(),
                horarioFuncionamentoEntity.getDataAtualizacao()
        );
    }

    public static HorarioFuncionamento toDomain(HorarioFuncionamentoRequest horarioFuncionamentoRequest) {
        return new HorarioFuncionamento(
                null,
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.segunda()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.terca()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.quarta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.quinta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.sexta()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.sabado()),
                HorarioUnidadePresenter.toDomain(horarioFuncionamentoRequest.domingo()),
                null,
                null
        );
    }

    public static HorarioFuncionamentoResponse toResponse(HorarioFuncionamento result) {
        if (result == null) return null;
        return new HorarioFuncionamentoResponse(
                result.id(),
                HorarioUnidadePresenter.toResponse(result.segunda()),
                HorarioUnidadePresenter.toResponse(result.terca()),
                HorarioUnidadePresenter.toResponse(result.quarta()),
                HorarioUnidadePresenter.toResponse(result.quinta()),
                HorarioUnidadePresenter.toResponse(result.sexta()),
                HorarioUnidadePresenter.toResponse(result.sabado()),
                HorarioUnidadePresenter.toResponse(result.domingo()),
                result.dataCriacao(),
                result.dataAtualizacao()
        );
    }

    public static HorarioFuncionamentoEntity toEntity(HorarioFuncionamento horarioFuncionamento) {
        if (horarioFuncionamento == null) return null;
        return HorarioFuncionamentoEntity.builder()
                .id(Objects.isNull(horarioFuncionamento.id()) ? null : horarioFuncionamento.id())
                .segunda(HorarioUnidadePresenter.toModel(horarioFuncionamento.segunda()))
                .terca(HorarioUnidadePresenter.toModel(horarioFuncionamento.terca()))
                .quarta(HorarioUnidadePresenter.toModel(horarioFuncionamento.quarta()))
                .quinta(HorarioUnidadePresenter.toModel(horarioFuncionamento.quinta()))
                .sexta(HorarioUnidadePresenter.toModel(horarioFuncionamento.sexta()))
                .sabado(HorarioUnidadePresenter.toModel(horarioFuncionamento.sabado()))
                .domingo(HorarioUnidadePresenter.toModel(horarioFuncionamento.domingo()))
                .dataCriacao(horarioFuncionamento.dataCriacao())
                .dataAtualizacao(horarioFuncionamento.dataAtualizacao())
                .build();
    }
}
