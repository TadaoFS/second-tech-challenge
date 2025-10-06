package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import org.springframework.stereotype.Component;

@Component
public class SemanaFuncionamentoDTOMapper {

    DiaDTOMapper diaDTOMapper;

    public SemanaFuncionamentoDTOMapper(DiaDTOMapper diaDTOMapper) {
        this.diaDTOMapper = diaDTOMapper;
    }

    public SemanaFuncionamento toDomain(SemanaFuncionamentoDTO dto) {
        if (dto == null) {
            return null;
        }

        SemanaFuncionamento s = new SemanaFuncionamento();

        s.setId(dto.id());
        s.setSegunda(diaDTOMapper.toDomain(dto.segunda()));
        s.setTerca(diaDTOMapper.toDomain(dto.terca()));
        s.setQuarta(diaDTOMapper.toDomain(dto.quarta()));
        s.setQuinta(diaDTOMapper.toDomain(dto.quinta()));
        s.setSexta(diaDTOMapper.toDomain(dto.sexta()));
        s.setSabado(diaDTOMapper.toDomain(dto.sabado()));
        s.setDomingo(diaDTOMapper.toDomain(dto.domingo()));

        return s;
    }

    public SemanaFuncionamentoDTO toDTO(SemanaFuncionamento semanaFuncionamento) {
        if (semanaFuncionamento == null) {
            return null;
        }

        return new SemanaFuncionamentoDTO(
                semanaFuncionamento.getId(),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getSegunda()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getTerca()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getQuarta()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getQuinta()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getSexta()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getSabado()),
                this.diaDTOMapper.toDTO(semanaFuncionamento.getDomingo())
        );
    }
}
