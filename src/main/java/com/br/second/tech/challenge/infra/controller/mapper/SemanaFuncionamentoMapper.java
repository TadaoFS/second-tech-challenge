package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class SemanaFuncionamentoMapper {

    DiaMapper diaMapper;

    public SemanaFuncionamentoMapper(DiaMapper diaMapper) {
        this.diaMapper = diaMapper;
    }

    public SemanaFuncionamentoEntity toEntity(SemanaFuncionamentoDTO dto) {
        if (dto == null) {
            return null;
        }
        SemanaFuncionamentoEntity semanaEntity = new SemanaFuncionamentoEntity();

        semanaEntity.setId(dto.id());
        semanaEntity.setSegunda(diaMapper.toEntity(dto.segunda()));
        semanaEntity.setTerca(diaMapper.toEntity(dto.terca()));
        semanaEntity.setQuarta(diaMapper.toEntity(dto.quarta()));
        semanaEntity.setQuinta(diaMapper.toEntity(dto.quinta()));
        semanaEntity.setSexta(diaMapper.toEntity(dto.sexta()));
        semanaEntity.setSabado(diaMapper.toEntity(dto.sabado()));
        semanaEntity.setDomingo(diaMapper.toEntity(dto.domingo()));

        return semanaEntity;
    }

    public SemanaFuncionamentoDTO toDTO(SemanaFuncionamentoEntity entity) {
        if (entity == null) {
            return null;
        }

        return new SemanaFuncionamentoDTO(
                entity.getId(),
                this.diaMapper.toDTO(entity.getSegunda()),
                this.diaMapper.toDTO(entity.getTerca()),
                this.diaMapper.toDTO(entity.getQuarta()),
                this.diaMapper.toDTO(entity.getQuinta()),
                this.diaMapper.toDTO(entity.getSexta()),
                this.diaMapper.toDTO(entity.getSabado()),
                this.diaMapper.toDTO(entity.getDomingo())
        );
    }
}
