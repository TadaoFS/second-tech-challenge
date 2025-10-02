package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import org.springframework.stereotype.Component;

@Component
public class DiaDTOMapper {

    public Dia toDomain(DiaDTO dto) {
        if (dto == null) {
            return null;
        }
        Dia dia = new Dia();

        dia.setId(dto.id());
        dia.setNome(dto.nome());
        dia.setAberto(dto.aberto());
        dia.setHorarioAbertura(dto.horarioAbertura());
        dia.setHorarioFechamento(dto.horarioFechamento());

        return dia;
    }

    public DiaDTO toDTO(Dia dia) {
        if (dia == null) {
            return null;
        }
        return new DiaDTO(
                dia.getId(),
                dia.getNome(),
                dia.isAberto(),
                dia.getHorarioAbertura(),
                dia.getHorarioFechamento()
        );
    }
}
