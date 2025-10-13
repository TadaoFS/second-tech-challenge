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
                SemanaFuncionamentoPresenter.toDomain(entity.getSemanaFuncionamento()),
                UsuarioPresenter.toDomain(entity.getUsuario()),
                EnderecoPresenter.toDomain(entity.getEnderecoEntity()),
                entity.getDataCriacao(),
                entity.getDataAtualizacao()
        );
    }

    public static Restaurante toDomain(RestauranteCreateRequest request) {
        return new Restaurante(
                request.nome(),
                request.tipoCozinha(),
                SemanaFuncionamentoPresenter.toDomain(request.horarioFuncionamento()),
                request.idDonoRestaurante(),
                EnderecoPresenter.toDomain(request.endereco())
        );
    }

    public static Restaurante toDomain(RestauranteUpdateRequest request) {
        return new Restaurante(
                request.id(),
                request.nome(),
                request.tipoCozinha(),
                SemanaFuncionamentoPresenter.toDomain(request.horarioFuncionamento()),
                request.donoRestaurante(),
                EnderecoPresenter.toDomain(request.endereco())
        );
    }

    public static RestauranteResponse toResponse(Restaurante restaurante) {
        return new RestauranteResponse(
                restaurante.id(),
                restaurante.nome(),
                restaurante.tipoCozinha(),
                SemanaFuncionamentoPresenter.toResponse(restaurante.semanaFuncionamento()),
                UsuarioPresenter.toResponse(restaurante.usuario()),
                EnderecoPresenter.toRespone(restaurante.endereco())
        );
    }
}

