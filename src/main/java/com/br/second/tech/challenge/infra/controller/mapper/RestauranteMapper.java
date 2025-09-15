package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;


public class RestauranteMapper {

    public RestauranteEntity toEntity(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }
        RestauranteEntity restauranteEntity = new RestauranteEntity();

        restauranteEntity.setId(dto.id());
        restauranteEntity.setNome(dto.nome());
        restauranteEntity.setTipoCozinha(dto.tipoCozinha());
        restauranteEntity.setEnderecoEntity(dto.enderecoEntity());
        restauranteEntity.setCardapioEntities(dto.cardapioEntities());
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
                entity.getDiasFuncionamento(),
                entity.getUsuario(),
                entity.getCardapioEntities(),
                entity.getEnderecoEntity()
        );
    }
}
