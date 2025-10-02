package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DiaDTOMapperTest {

    private DiaDTOMapper mapper;

    @BeforeEach
    void given() {
        mapper = new DiaDTOMapper();
    }

    @Test
    @DisplayName("retorna Entity Null para DiaDTO null")
    void retornaNullparaDTOnull() {
        assertNull(mapper.toDomain(null));
    }

    @Test
    @DisplayName("retorna DTO Null para DiaEntity null")
    void retornaNullparaEntitynull() {
        assertNull(mapper.toDTO(null));
    }

    @Test
    @DisplayName("retorna Entity correta")
    void toEntity() {
        // Given
        Long id = 1L;
        Dias nome = Dias.SEGUNDA;
        boolean aberto = true;
        String horarioAbertura = "0800";
        String horarioFechamento = "1800";

        DiaDTO dto = new DiaDTO(id, nome, aberto, horarioAbertura, horarioFechamento);

        // When
        Dia dia = mapper.toDomain(dto);

        // Then
        assertNotNull(dto);
        assertEquals(dia.getId(), dto.id());
        assertEquals(dia.getNome(), dto.nome());
        assertEquals(dia.isAberto(), dto.aberto());
        assertEquals(dia.getHorarioAbertura(), dto.horarioAbertura());
        assertEquals(dia.getHorarioFechamento(), dto.horarioFechamento());
    }

    @Test
    @DisplayName("retorna DTO correto")
    void toDTO() {
        // Given
        Dia dia = new Dia();
        dia.setId(1L);
        dia.setNome(Dias.SEGUNDA);
        dia.setAberto(true);
        dia.setHorarioAbertura("08:00");
        dia.setHorarioFechamento("18:00");

        // When
        DiaDTO dto = mapper.toDTO(dia);

        // Then
        assertNotNull(dto);
        assertEquals(dia.getId(), dto.id());
        assertEquals(dia.getNome(), dto.nome());
        assertEquals(dia.isAberto(), dto.aberto());
        assertEquals(dia.getHorarioAbertura(), dto.horarioAbertura());
        assertEquals(dia.getHorarioFechamento(), dto.horarioFechamento());
    }
}
