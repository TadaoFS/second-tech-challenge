package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import org.springframework.stereotype.Component;

@Component
public class DiaDTOMapper {

    public Dia toDomain(DiaDTO dto) {
        if (dto == null) return null;
        return new Dia(dto.id(), dto.nome(), dto.aberto(), dto.horarioAbertura(), dto.horarioFechamento());
    }

    public DiaDTO toDTO(Dia dia) {
        if (dia == null) {
            return null;
        }
        return new DiaDTO(
                dia.id(),
                dia.nome(),
                dia.aberto(),
                dia.horarioAbertura(),
                dia.horarioFechamento()
        );
    }
}
