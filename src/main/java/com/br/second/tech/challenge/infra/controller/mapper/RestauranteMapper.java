package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestauranteMapper {

    SemanaFuncionamentoMapper semanaFuncionamentoMapper;

    public RestauranteMapper(SemanaFuncionamentoMapper semanaFuncionamentoMapper) {
        this.semanaFuncionamentoMapper = semanaFuncionamentoMapper;
    }

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
        restauranteEntity.setSemanaFuncionamento(semanaFuncionamentoMapper.toEntity(dto.semanaFuncionamento()));
        restauranteEntity.setUsuario(dto.usuario());
        restauranteEntity.setDataAtualizacao(LocalDateTime.now());

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
                semanaFuncionamentoMapper.toDTO(entity.getSemanaFuncionamento()),
                entity.getUsuario(),
                entity.getCardapioEntities(),
                entity.getEnderecoEntity()
        );
    }
}
