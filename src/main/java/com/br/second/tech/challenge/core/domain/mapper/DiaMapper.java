package com.br.second.tech.challenge.core.domain.mapper;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;


public class DiaMapper {

    public static Dia toDomain(DiaEntity entity) {
        if (entity == null) return null;
        Dia d = new Dia();
        d.setId(entity.getId());
        d.setNome(entity.getNome());
        d.setHorarioAbertura(entity.getHorarioAbertura());
        d.setHorarioFechamento(entity.getHorarioFechamento());
        return d;
    }

    public static DiaEntity toEntity(Dia dia) {
        if (dia == null) return null;
        DiaEntity e = new DiaEntity();
        e.setId(dia.getId());
        e.setNome(dia.getNome());
        e.setHorarioAbertura(dia.getHorarioAbertura());
        e.setHorarioFechamento(dia.getHorarioFechamento());
        return e;
    }
}

