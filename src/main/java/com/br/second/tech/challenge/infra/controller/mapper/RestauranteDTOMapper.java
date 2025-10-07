package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestauranteDTOMapper {

    SemanaFuncionamentoDTOMapper semanaFuncionamentoDTOMapper;

    public RestauranteDTOMapper(SemanaFuncionamentoDTOMapper semanaFuncionamentoDTOMapper) {
        this.semanaFuncionamentoDTOMapper = semanaFuncionamentoDTOMapper;
    }

    public Restaurante toDomain(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }

        Restaurante r = new Restaurante();

        r.setId(dto.id());
        r.setNome(dto.nome());
        r.setTipoCozinha(dto.tipoCozinha());
        r.setEnderecoEntity(dto.enderecoEntity());
        r.setCardapioEntities(dto.cardapioEntities());
        r.setSemanaFuncionamento(semanaFuncionamentoDTOMapper.toDomain(dto.semanaFuncionamento()));
        r.setUsuario(dto.usuario());
        r.setDataAtualizacao(LocalDateTime.now());
        return new Restaurante(
                dto.id(),
                dto.nome(),
                dto.tipoCozinha(),
                dto.enderecoEntity(),
                dto.cardapioEntities(),
                dto.semanaFuncionamento(),
                dto.usuario(),
                LocalDateTime.now()
        );
    }

    public RestauranteDTO toDTO(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }
        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getTipoCozinha(),
                semanaFuncionamentoDTOMapper.toDTO(restaurante.getSemanaFuncionamento()),
                restaurante.getUsuario(),
                restaurante.getCardapioEntities(),
                restaurante.getEnderecoEntity()
        );
    }
}
