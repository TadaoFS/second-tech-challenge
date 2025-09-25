package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DiaMapper {

    public DiaEntity toEntity(DiaDTO dto) {
        if (dto == null) {
            return null;
        }
        DiaEntity dia = new DiaEntity();

        dia.setId(dto.id());
        dia.setNome(dto.nome());
        dia.setAberto(dto.aberto());
        dia.setHorarioAbertura(dto.horarioAbertura());
        dia.setHorarioFechamento(dto.horarioFechamento());

        return dia;
    }

    public DiaDTO toDTO(DiaEntity entity) {
        if (entity == null) {
            return null;
        }
        return new DiaDTO(
                entity.getId(),
                entity.getNome(),
                entity.isAberto(),
                entity.getHorarioAbertura(),
                entity.getHorarioFechamento()
        );
    }
}
