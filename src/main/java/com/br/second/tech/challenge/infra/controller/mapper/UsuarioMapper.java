package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.UsuarioDTO;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(UsuarioEntity entity) {
        return new UsuarioDTO(
                entity.getId(),
                entity.getEmail(),
                entity.getNome(),
                entity.getSobrenome(),
                entity.getLogin(),
                entity.getStatus(),
                entity.getDataCriacao(),
                entity.getDataAtualizacao(),
                entity.getEnderecoEntity(),
                entity.getTipoUsuario(),
                entity.getRestauranteEntity() != null
                        ? new RestauranteDTO(
                        entity.getRestauranteEntity().getId(),
                        entity.getRestauranteEntity().getNome(),
                        entity.getRestauranteEntity().getTipoCozinha()
                )
                        : null
        );
    }

    public static UsuarioEntity toEntity(UsuarioDTO dto) {
        return UsuarioEntity.builder()
                .id(dto.id())
                .email(dto.email())
                .nome(dto.nome())
                .sobrenome(dto.sobrenome())
                .login(dto.login())
                .status(dto.status())
                .dataCriacao(dto.dataCriacao())
                .dataAtualizacao(dto.dataAtualizacao())
                .enderecoEntity(dto.endereco())
                .tipoUsuario(dto.tipoUsuario())
                .restauranteEntity(dto.restaurante() != null
                        ? RestauranteEntity.builder()
                        .id(dto.restaurante().id())
                        .nome(dto.restaurante().nome())
                        .tipoCozinha(dto.restaurante().tipoCozinha())
                        .build()
                        : null
                )
                .build();
    }
}
