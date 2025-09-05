package com.br.second.tech.challenge.app.mapper;

import com.br.second.tech.challenge.app.domain.entities.Restaurante;
import com.br.second.tech.challenge.app.dto.RestauranteDTO;

public class RestauranteMapper {

    public Restaurante toEntity(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }
        Restaurante restaurante = new Restaurante();

        restaurante.setId(dto.id());
        restaurante.setNome(dto.nome());
        restaurante.setTipoCozinha(dto.tipoCozinha());
        restaurante.setEndereco(dto.endereco());
        restaurante.setCardapios(dto.cardapios());
        restaurante.setDiasFuncionamento(dto.diasFuncionamento());
        restaurante.setUsuario(dto.usuario());

        return restaurante;
    }

    public RestauranteDTO toDTO(Restaurante entity) {
        if (entity == null) {
            return null;
        }
        return new RestauranteDTO(
                entity.getId(),
                entity.getNome(),
                entity.getTipoCozinha(),
                entity.getDiasFuncionamento(),
                entity.getUsuario(),
                entity.getCardapios(),
                entity.getEndereco()
        );
    }
}
