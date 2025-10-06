package com.br.second.tech.challenge.core.domain.mapper;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.core.domain.mapper.SemanaFuncionamentoMapper;

public class RestauranteMapper {
    public static Restaurante toDomain(RestauranteEntity entity) {
        if (entity == null) return null;
        Restaurante r = new Restaurante();
        r.setId(entity.getId());
        r.setNome(entity.getNome());
        r.setDataCriacao(entity.getDataCriacao());
        r.setDataAtualizacao(entity.getDataAtualizacao());
        r.setSemanaFuncionamento(SemanaFuncionamentoMapper.toDomain(entity.getSemanaFuncionamento()));
        r.setTipoCozinha(entity.getTipoCozinha());
        r.setUsuario(entity.getUsuario());
        r.setCardapioEntities(entity.getCardapioEntities());
        r.setEnderecoEntity(entity.getEnderecoEntity());
        return r;
    }
    public static RestauranteEntity toEntity(Restaurante restaurante) {
        if (restaurante == null) return null;
        RestauranteEntity e = new RestauranteEntity();
        e.setId(restaurante.getId());
        e.setNome(restaurante.getNome());
        e.setTipoCozinha(restaurante.getTipoCozinha());
        e.setDataCriacao(restaurante.getDataCriacao());
        e.setDataAtualizacao(restaurante.getDataAtualizacao());
        e.setSemanaFuncionamento(SemanaFuncionamentoMapper.toEntity(restaurante.getSemanaFuncionamento()));
        e.setUsuario(restaurante.getUsuario());
        e.setCardapioEntities(restaurante.getCardapioEntities());
        e.setEnderecoEntity(restaurante.getEnderecoEntity());

        return e;
    }
}

