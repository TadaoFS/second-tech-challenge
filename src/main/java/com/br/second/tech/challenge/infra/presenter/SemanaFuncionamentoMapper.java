package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;

public class SemanaFuncionamentoMapper {

    public static SemanaFuncionamento toDomain(SemanaFuncionamentoEntity entity) {
        if (entity == null) return null;
        SemanaFuncionamento s = new SemanaFuncionamento();
        s.setId(entity.getId());
        s.setSegunda(DiaMapper.toDomain(entity.getSegunda()));
        s.setTerca(DiaMapper.toDomain(entity.getTerca()));
        s.setQuarta(DiaMapper.toDomain(entity.getQuarta()));
        s.setQuinta(DiaMapper.toDomain(entity.getQuinta()));
        s.setSexta(DiaMapper.toDomain(entity.getSexta()));
        s.setSabado(DiaMapper.toDomain(entity.getSabado()));
        s.setDomingo(DiaMapper.toDomain(entity.getDomingo()));
        s.setDataCriacao(entity.getDataCriacao());
        s.setDataAtualizacao(entity.getDataAtualizacao());

        return s;
    }

    public static SemanaFuncionamentoEntity toEntity(SemanaFuncionamento semana) {
        if (semana == null) return null;
        SemanaFuncionamentoEntity e = new SemanaFuncionamentoEntity();

        e.setId(semana.getId());
        e.setSegunda(DiaMapper.toEntity(semana.getSegunda()));
        e.setTerca(DiaMapper.toEntity(semana.getTerca()));
        e.setQuarta(DiaMapper.toEntity(semana.getQuarta()));
        e.setQuinta(DiaMapper.toEntity(semana.getQuinta()));
        e.setSexta(DiaMapper.toEntity(semana.getSexta()));
        e.setSabado(DiaMapper.toEntity(semana.getSabado()));
        e.setDomingo(DiaMapper.toEntity(semana.getDomingo()));
        e.setDataCriacao(semana.getDataCriacao());
        e.setDataAtualizacao(semana.getDataAtualizacao());

        return e;
    }
}

