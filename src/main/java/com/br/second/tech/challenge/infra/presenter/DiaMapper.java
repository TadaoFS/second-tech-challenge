package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;


public class DiaMapper {

    public static Dia toDomain(DiaEntity entity) {
        if (entity == null) return null;
        return new Dia(entity.getId(), entity.getNome(), entity.getHorarioAbertura(), entity.getHorarioFechamento());
    }

    public static DiaEntity toEntity(Dia dia) {
        if (dia == null) return null;
        DiaEntity e = new DiaEntity();
        e.setId(dia.id());
        e.setNome(dia.nome());
        e.setHorarioAbertura(dia.horarioAbertura());
        e.setHorarioFechamento(dia.horarioFechamento());
        return e;
    }
}

