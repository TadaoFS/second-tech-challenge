package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SemanaFuncionamentoMapperTest {

    @Mock
    private DiaMapper diaMapper;

    private SemanaFuncionamentoMapper mapper;

    private DiaDTO createDiaDTO(Dias dia) {
        return new DiaDTO(1L, dia, true, "08:00", "18:00");
    }

    private DiaEntity createDiaEntity(Dias dia) {
        DiaEntity entity = new DiaEntity();
        entity.setId(1L);
        entity.setNome(dia);
        entity.setAberto(true);
        entity.setHorarioAbertura("08:00");
        entity.setHorarioFechamento("18:00");
        return entity;
    }

    @BeforeEach
    void given() {
        mapper = new SemanaFuncionamentoMapper(diaMapper);
    }

    @Test
    @DisplayName("retorna Entity Null para SemanaFuncionamentoDTO null")
    void retornaNullparaDTOnull() {
        assertNull(mapper.toEntity(null));
    }

    @Test
    @DisplayName("retorna DTO Null para SemanaFuncionamentoEntity null")
    void retornaNullparaEntitynull() {
        assertNull(mapper.toDTO(null));
    }

    @Test
    @DisplayName("retorna Entity correta")
    void toEntity() {
        // Given
        DiaDTO segundaDTO = createDiaDTO(Dias.SEGUNDA);
        DiaDTO tercaDTO = createDiaDTO(Dias.TERCA);
        DiaDTO quartaDTO = createDiaDTO(Dias.QUARTA);
        DiaDTO quintaDTO = createDiaDTO(Dias.QUINTA);
        DiaDTO sextaDTO = createDiaDTO(Dias.SEXTA);
        DiaDTO sabadoDTO = createDiaDTO(Dias.SABADO);
        DiaDTO domingoDTO = createDiaDTO(Dias.DOMINGO);

        SemanaFuncionamentoDTO dto = SemanaFuncionamentoDTO.builder()
                .id(1L)
                .segunda(segundaDTO)
                .terca(tercaDTO)
                .quarta(quartaDTO)
                .quinta(quintaDTO)
                .sexta(sextaDTO)
                .sabado(sabadoDTO)
                .domingo(domingoDTO)
                .build();

        DiaEntity segundaEntity = createDiaEntity(Dias.SEGUNDA);
        DiaEntity tercaEntity = createDiaEntity(Dias.TERCA);
        DiaEntity quartaEntity = createDiaEntity(Dias.QUARTA);
        DiaEntity quintaEntity = createDiaEntity(Dias.QUINTA);
        DiaEntity sextaEntity = createDiaEntity(Dias.SEXTA);
        DiaEntity sabadoEntity = createDiaEntity(Dias.SABADO);
        DiaEntity domingoEntity = createDiaEntity(Dias.DOMINGO);

        when(diaMapper.toEntity(segundaDTO)).thenReturn(segundaEntity);
        when(diaMapper.toEntity(tercaDTO)).thenReturn(tercaEntity);
        when(diaMapper.toEntity(quartaDTO)).thenReturn(quartaEntity);
        when(diaMapper.toEntity(quintaDTO)).thenReturn(quintaEntity);
        when(diaMapper.toEntity(sextaDTO)).thenReturn(sextaEntity);
        when(diaMapper.toEntity(sabadoDTO)).thenReturn(sabadoEntity);
        when(diaMapper.toEntity(domingoDTO)).thenReturn(domingoEntity);

        // When
        SemanaFuncionamentoEntity entity = mapper.toEntity(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.id(), entity.getId());
        assertEquals(segundaEntity, entity.getSegunda());
        assertEquals(tercaEntity, entity.getTerca());
        assertEquals(quartaEntity, entity.getQuarta());
        assertEquals(quintaEntity, entity.getQuinta());
        assertEquals(sextaEntity, entity.getSexta());
        assertEquals(sabadoEntity, entity.getSabado());
        assertEquals(domingoEntity, entity.getDomingo());

        verify(diaMapper).toEntity(segundaDTO);
        verify(diaMapper).toEntity(tercaDTO);
        verify(diaMapper).toEntity(quartaDTO);
        verify(diaMapper).toEntity(quintaDTO);
        verify(diaMapper).toEntity(sextaDTO);
        verify(diaMapper).toEntity(sabadoDTO);
        verify(diaMapper).toEntity(domingoDTO);
    }

    @Test
    @DisplayName("retorna DTO correto")
    void toDTO() {
        // Given
        DiaEntity segundaEntity = createDiaEntity(Dias.SEGUNDA);
        DiaEntity tercaEntity = createDiaEntity(Dias.TERCA);
        DiaEntity quartaEntity = createDiaEntity(Dias.QUARTA);
        DiaEntity quintaEntity = createDiaEntity(Dias.QUINTA);
        DiaEntity sextaEntity = createDiaEntity(Dias.SEXTA);
        DiaEntity sabadoEntity = createDiaEntity(Dias.SABADO);
        DiaEntity domingoEntity = createDiaEntity(Dias.DOMINGO);

        SemanaFuncionamentoEntity entity = new SemanaFuncionamentoEntity();
        entity.setId(1L);
        entity.setSegunda(segundaEntity);
        entity.setTerca(tercaEntity);
        entity.setQuarta(quartaEntity);
        entity.setQuinta(quintaEntity);
        entity.setSexta(sextaEntity);
        entity.setSabado(sabadoEntity);
        entity.setDomingo(domingoEntity);

        DiaDTO segundaDTO = createDiaDTO(Dias.SEGUNDA);
        DiaDTO tercaDTO = createDiaDTO(Dias.TERCA);
        DiaDTO quartaDTO = createDiaDTO(Dias.QUARTA);
        DiaDTO quintaDTO = createDiaDTO(Dias.QUINTA);
        DiaDTO sextaDTO = createDiaDTO(Dias.SEXTA);
        DiaDTO sabadoDTO = createDiaDTO(Dias.SABADO);
        DiaDTO domingoDTO = createDiaDTO(Dias.DOMINGO);

        when(diaMapper.toDTO(segundaEntity)).thenReturn(segundaDTO);
        when(diaMapper.toDTO(tercaEntity)).thenReturn(tercaDTO);
        when(diaMapper.toDTO(quartaEntity)).thenReturn(quartaDTO);
        when(diaMapper.toDTO(quintaEntity)).thenReturn(quintaDTO);
        when(diaMapper.toDTO(sextaEntity)).thenReturn(sextaDTO);
        when(diaMapper.toDTO(sabadoEntity)).thenReturn(sabadoDTO);
        when(diaMapper.toDTO(domingoEntity)).thenReturn(domingoDTO);

        // When
        SemanaFuncionamentoDTO dto = mapper.toDTO(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.id());
        assertEquals(segundaDTO, dto.segunda());
        assertEquals(tercaDTO, dto.terca());
        assertEquals(quartaDTO, dto.quarta());
        assertEquals(quintaDTO, dto.quinta());
        assertEquals(sextaDTO, dto.sexta());
        assertEquals(sabadoDTO, dto.sabado());
        assertEquals(domingoDTO, dto.domingo());

        verify(diaMapper).toDTO(segundaEntity);
        verify(diaMapper).toDTO(tercaEntity);
        verify(diaMapper).toDTO(quartaEntity);
        verify(diaMapper).toDTO(quintaEntity);
        verify(diaMapper).toDTO(sextaEntity);
        verify(diaMapper).toDTO(sabadoEntity);
        verify(diaMapper).toDTO(domingoEntity);
    }
}
