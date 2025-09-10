package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.app.dto.RestauranteDTO;

public class RestauranteMapper {

    public RestauranteEntity toEntity(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }
        RestauranteEntity restauranteEntity = new RestauranteEntity();

        restauranteEntity.setId(dto.id());
        restauranteEntity.setNome(dto.nome());
        restauranteEntity.setTipoCozinha(dto.tipoCozinha());
        restauranteEntity.setEndereco(dto.endereco());
        restauranteEntity.setCardapios(dto.cardapioEntities());
        restauranteEntity.setDiasFuncionamento(dto.diasFuncionamento());
        restauranteEntity.setUsuario(dto.usuario());

        return restauranteEntity;
    }

    public RestauranteDTO toDTO(RestauranteEntity entity) {
        if (entity == null) {
            return null;
        }
        return new RestauranteDTO(
                entity.getId(),
                entity.getNome(),
                entity.getTipoCozinha(),
                entity.getDataCriacao(),
                entity.getDataAtualizacao(),
                entity.getDiasFuncionamento(),
                entity.getUsuario(),
                entity.getCardapios(),
                entity.getEndereco()
        );
    }
}
