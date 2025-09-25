package com.br.second.tech.challenge.infra.controller.mapper;

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
class DiaMapperTest {

    private DiaMapper mapper;

    @BeforeEach
    void given() {
        mapper = new DiaMapper();
    }

    @Test
    @DisplayName("retorna Entity Null para DiaDTO null")
    void retornaNullparaDTOnull() {
        assertNull(mapper.toEntity(null));
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
        DiaEntity entity = mapper.toEntity(dto);

        // Then
        assertNotNull(entity);
        assertEquals(id, entity.getId());
        assertEquals(nome, entity.getNome());
        assertEquals(aberto, entity.isAberto());
        assertEquals("08:00", entity.getHorarioAbertura());
        assertEquals("18:00", entity.getHorarioFechamento());
    }

    @Test
    @DisplayName("retorna DTO correto")
    void toDTO() {
        // Given
        DiaEntity entity = new DiaEntity();
        entity.setId(1L);
        entity.setNome(Dias.SEGUNDA);
        entity.setAberto(true);
        entity.setHorarioAbertura("08:00");
        entity.setHorarioFechamento("18:00");

        // When
        DiaDTO dto = mapper.toDTO(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.id());
        assertEquals(entity.getNome(), dto.nome());
        assertEquals(entity.isAberto(), dto.aberto());
        assertEquals(entity.getHorarioAbertura(), dto.horarioAbertura());
        assertEquals(entity.getHorarioFechamento(), dto.horarioFechamento());
    }
}
