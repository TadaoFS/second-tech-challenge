package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.infra.controller.restaurante.request.SemanaFuncionamentoRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.SemanaFuncionamentoResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.SemanaFuncionamentoEntity;

public class SemanaFuncionamentoPresenter {

    public static SemanaFuncionamento toDomain(SemanaFuncionamentoEntity semanaFuncionamento) {
        return new SemanaFuncionamento(
                semanaFuncionamento.getId(),
                DiaPresenter.toDomain(semanaFuncionamento.getSegunda()),
                DiaPresenter.toDomain(semanaFuncionamento.getTerca()),
                DiaPresenter.toDomain(semanaFuncionamento.getQuarta()),
                DiaPresenter.toDomain(semanaFuncionamento.getQuinta()),
                DiaPresenter.toDomain(semanaFuncionamento.getSexta()),
                DiaPresenter.toDomain(semanaFuncionamento.getSabado()),
                DiaPresenter.toDomain(semanaFuncionamento.getDomingo()),
                semanaFuncionamento.getDataCriacao(),
                semanaFuncionamento.getDataAtualizacao()
        );
    }

    public static SemanaFuncionamento toDomain(SemanaFuncionamentoRequest semanaFuncionamentoRequest) {
        return new SemanaFuncionamento(
                DiaPresenter.toDomain(semanaFuncionamentoRequest.segunda()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.terca()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.quarta()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.quinta()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.sexta()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.sabado()),
                DiaPresenter.toDomain(semanaFuncionamentoRequest.domingo())
        );
    }

    public static SemanaFuncionamentoResponse toResponse(SemanaFuncionamento result) {
        if (result == null) return null;
        return new SemanaFuncionamentoResponse(
                result.id(),
                DiaPresenter.toResponse(result.segunda()),
                DiaPresenter.toResponse(result.terca()),
                DiaPresenter.toResponse(result.quarta()),
                DiaPresenter.toResponse(result.quinta()),
                DiaPresenter.toResponse(result.sexta()),
                DiaPresenter.toResponse(result.sabado()),
                DiaPresenter.toResponse(result.domingo())
        );
    }
}
