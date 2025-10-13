package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.controller.restaurante.request.RestauranteCreateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.request.RestauranteUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.RestauranteResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.RestauranteEntity;

public class RestaurantePresenter {

    public static Restaurante toDomain(RestauranteEntity entity) {
        if (entity == null) return null;
        return new Restaurante(
                entity.getId(),
                entity.getNome(),
                entity.getTipoCozinha(),
                HorarioFuncionamentoPresenter.toDomain(entity.getHorarioFuncionamento()),
                UsuarioPresenter.toDomain(entity.getUsuario()),
                EnderecoPresenter.toDomain(entity.getEndereco()),
                entity.getDataCriacao(),
                entity.getDataAtualizacao()
        );
    }

    public static Restaurante toDomain(RestauranteCreateRequest request) {
        return new Restaurante(
                request.nome(),
                request.tipoCozinha(),
                HorarioFuncionamentoPresenter.toDomain(request.horarioFuncionamento()),
                request.idDonoRestaurante(),
                EnderecoPresenter.toDomain(request.endereco())
        );
    }

    public static Restaurante toDomain(RestauranteUpdateRequest request) {
        return new Restaurante(
                request.id(),
                request.nome(),
                request.tipoCozinha(),
                null,
                request.idDonoRestaurante(),
                EnderecoPresenter.toDomain(request.endereco())
        );
    }

    public static RestauranteResponse toResponse(Restaurante restaurante) {
        return new RestauranteResponse(
                restaurante.id(),
                restaurante.nome(),
                restaurante.tipoCozinha(),
                HorarioFuncionamentoPresenter.toResponse(restaurante.horarioFuncionamento()),
                restaurante.usuario().id(),
                EnderecoPresenter.toRespone(restaurante.endereco()),
                restaurante.dataCriacao(),
                restaurante.dataAtualizacao()
        );
    }

    public static RestauranteEntity toEntity(Restaurante restaurante) {
        if (restaurante == null) return null;
        return RestauranteEntity.builder()
                .nome(restaurante.nome())
                .tipoCozinha(restaurante.tipoCozinha())
                .horarioFuncionamento(HorarioFuncionamentoPresenter.toEntity(restaurante.horarioFuncionamento()))
                .usuario(UsuarioPresenter.toEntity(restaurante.usuario()))
                .endereco(EnderecoPresenter.toEntity(restaurante.endereco()))
                .dataCriacao(restaurante.dataCriacao())
                .dataAtualizacao(restaurante.dataAtualizacao())
                .build();
    }
}

