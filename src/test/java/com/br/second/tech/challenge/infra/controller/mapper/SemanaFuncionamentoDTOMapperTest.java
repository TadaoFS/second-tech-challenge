package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SemanaFuncionamentoDTOMapperTest {

    @Mock
    private DiaDTOMapper diaDTOMapper;

    private SemanaFuncionamentoDTOMapper mapper;

    private DiaDTO createDiaDTO(Dias dia) {
        return new DiaDTO(1L, dia, true, "08:00", "18:00");
    }

    private Dia createDia(Dias dia) {
        Dia d = new Dia();
        d.setId(1L);
        d.setNome(dia);
        d.setAberto(true);
        d.setHorarioAbertura("08:00");
        d.setHorarioFechamento("18:00");
        return d;
    }

    @BeforeEach
    void given() {
        mapper = new SemanaFuncionamentoDTOMapper(diaDTOMapper);
    }

    @Test
    @DisplayName("retorna Domain Null para SemanaFuncionamentoDTO null")
    void retornaNullparaDTOnull() {
        assertNull(mapper.toDomain(null));
    }

    @Test
    @DisplayName("retorna DTO Null para SemanaFuncionamento Domain null")
    void retornaNullparaDomainnull() {
        assertNull(mapper.toDTO(null));
    }

    @Test
    @DisplayName("retorna Domain correta")
    void toDomain() {
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

        Dia segunda = createDia(Dias.SEGUNDA);
        Dia terca = createDia(Dias.TERCA);
        Dia quarta = createDia(Dias.QUARTA);
        Dia quinta = createDia(Dias.QUINTA);
        Dia sexta = createDia(Dias.SEXTA);
        Dia sabado = createDia(Dias.SABADO);
        Dia domingo = createDia(Dias.DOMINGO);

        when(diaDTOMapper.toDomain(segundaDTO)).thenReturn(segunda);
        when(diaDTOMapper.toDomain(tercaDTO)).thenReturn(terca);
        when(diaDTOMapper.toDomain(quartaDTO)).thenReturn(quarta);
        when(diaDTOMapper.toDomain(quintaDTO)).thenReturn(quinta);
        when(diaDTOMapper.toDomain(sextaDTO)).thenReturn(sexta);
        when(diaDTOMapper.toDomain(sabadoDTO)).thenReturn(sabado);
        when(diaDTOMapper.toDomain(domingoDTO)).thenReturn(domingo);

        // When
        SemanaFuncionamento domain = mapper.toDomain(dto);

        // Then
        assertNotNull(domain);
        assertEquals(dto.id(), domain.getId());
        assertEquals(segunda, domain.getSegunda());
        assertEquals(terca, domain.getTerca());
        assertEquals(quarta, domain.getQuarta());
        assertEquals(quinta, domain.getQuinta());
        assertEquals(sexta, domain.getSexta());
        assertEquals(sabado, domain.getSabado());
        assertEquals(domingo, domain.getDomingo());

        verify(diaDTOMapper).toDomain(segundaDTO);
        verify(diaDTOMapper).toDomain(tercaDTO);
        verify(diaDTOMapper).toDomain(quartaDTO);
        verify(diaDTOMapper).toDomain(quintaDTO);
        verify(diaDTOMapper).toDomain(sextaDTO);
        verify(diaDTOMapper).toDomain(sabadoDTO);
        verify(diaDTOMapper).toDomain(domingoDTO);
    }

    @Test
    @DisplayName("retorna DTO correto")
    void toDTO() {
        // Given
        Dia segunda = createDia(Dias.SEGUNDA);
        Dia terca = createDia(Dias.TERCA);
        Dia quarta = createDia(Dias.QUARTA);
        Dia quinta = createDia(Dias.QUINTA);
        Dia sexta = createDia(Dias.SEXTA);
        Dia sabado = createDia(Dias.SABADO);
        Dia domingo = createDia(Dias.DOMINGO);

        SemanaFuncionamento domain = new SemanaFuncionamento();
        domain.setId(1L);
        domain.setSegunda(segunda);
        domain.setTerca(terca);
        domain.setQuarta(quarta);
        domain.setQuinta(quinta);
        domain.setSexta(sexta);
        domain.setSabado(sabado);
        domain.setDomingo(domingo);

        DiaDTO segundaDTO = createDiaDTO(Dias.SEGUNDA);
        DiaDTO tercaDTO = createDiaDTO(Dias.TERCA);
        DiaDTO quartaDTO = createDiaDTO(Dias.QUARTA);
        DiaDTO quintaDTO = createDiaDTO(Dias.QUINTA);
        DiaDTO sextaDTO = createDiaDTO(Dias.SEXTA);
        DiaDTO sabadoDTO = createDiaDTO(Dias.SABADO);
        DiaDTO domingoDTO = createDiaDTO(Dias.DOMINGO);

        when(diaDTOMapper.toDTO(segunda)).thenReturn(segundaDTO);
        when(diaDTOMapper.toDTO(terca)).thenReturn(tercaDTO);
        when(diaDTOMapper.toDTO(quarta)).thenReturn(quartaDTO);
        when(diaDTOMapper.toDTO(quinta)).thenReturn(quintaDTO);
        when(diaDTOMapper.toDTO(sexta)).thenReturn(sextaDTO);
        when(diaDTOMapper.toDTO(sabado)).thenReturn(sabadoDTO);
        when(diaDTOMapper.toDTO(domingo)).thenReturn(domingoDTO);

        // When
        SemanaFuncionamentoDTO dto = mapper.toDTO(domain);

        // Then
        assertNotNull(dto);
        assertEquals(domain.getId(), dto.id());
        assertEquals(segundaDTO, dto.segunda());
        assertEquals(tercaDTO, dto.terca());
        assertEquals(quartaDTO, dto.quarta());
        assertEquals(quintaDTO, dto.quinta());
        assertEquals(sextaDTO, dto.sexta());
        assertEquals(sabadoDTO, dto.sabado());
        assertEquals(domingoDTO, dto.domingo());

        verify(diaDTOMapper).toDTO(segunda);
        verify(diaDTOMapper).toDTO(terca);
        verify(diaDTOMapper).toDTO(quarta);
        verify(diaDTOMapper).toDTO(quinta);
        verify(diaDTOMapper).toDTO(sexta);
        verify(diaDTOMapper).toDTO(sabado);
        verify(diaDTOMapper).toDTO(domingo);
    }
}
