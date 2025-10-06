package com.br.second.tech.challenge.infra.database.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DiaEntityTest {

    @Test
    @DisplayName("construtor vazio")
    void construtorVazio() {
        DiaEntity diaEntity = new DiaEntity();

        assertNotNull(diaEntity);
        assertNull(diaEntity.getId());
        assertNull(diaEntity.getNome());
        assertFalse(diaEntity.isAberto());
        assertNull(diaEntity.getDataCriacao());
        assertNull(diaEntity.getDataAtualizacao());
    }

    @Test
    @DisplayName("construtor completo")
    void construtorCompleto() {
        //given
        Long id = 1L;
        Dias nome = Dias.SEGUNDA;
        boolean aberto = true;
        String horarioAbertura = "0800";
        String horarioFechamento = "1800";
        LocalDateTime dataCriacao = LocalDateTime.now();
        LocalDateTime dataAtualizacao = LocalDateTime.now();

        //when
        DiaEntity diaEntity = new DiaEntity(id, nome, aberto, horarioAbertura,
            horarioFechamento, dataCriacao, dataAtualizacao);

        //then
        assertEquals(id, diaEntity.getId());
        assertEquals(nome, diaEntity.getNome());
        assertTrue(diaEntity.isAberto());
        assertEquals("08:00", diaEntity.getHorarioAbertura());
        assertEquals("18:00", diaEntity.getHorarioFechamento());
        assertEquals(dataCriacao, diaEntity.getDataCriacao());
        assertEquals(dataAtualizacao, diaEntity.getDataAtualizacao());
    }

    @Test
    @DisplayName("setters e getters")
    void settersEGetters() {
        //given
        DiaEntity diaEntity = new DiaEntity();
        Long id = 1L;
        Dias nome = Dias.SEGUNDA;
        boolean aberto = true;
        String horarioAbertura = "0900";
        String horarioFechamento = "1700";
        LocalDateTime dataCriacao = LocalDateTime.now();
        LocalDateTime dataAtualizacao = LocalDateTime.now();

        //when
        diaEntity.setId(id);
        diaEntity.setNome(nome);
        diaEntity.setAberto(aberto);
        diaEntity.setHorarioAbertura(horarioAbertura);
        diaEntity.setHorarioFechamento(horarioFechamento);
        diaEntity.setDataCriacao(dataCriacao);
        diaEntity.setDataAtualizacao(dataAtualizacao);

        //then
        assertEquals(id, diaEntity.getId());
        assertEquals(nome, diaEntity.getNome());
        assertTrue(diaEntity.isAberto());
        assertEquals("09:00", diaEntity.getHorarioAbertura());
        assertEquals("17:00", diaEntity.getHorarioFechamento());
        assertEquals(dataCriacao, diaEntity.getDataCriacao());
        assertEquals(dataAtualizacao, diaEntity.getDataAtualizacao());
    }

    @Test
    @DisplayName("formatação de horário abertura")
    void getHorarioAbertura() {
        //given
        DiaEntity diaEntity = new DiaEntity();

        //when
        diaEntity.setHorarioAbertura("1430");

        //then
        assertEquals("14:30", diaEntity.getHorarioAbertura());
    }

    @Test
    @DisplayName("formatação de horário fechamento")
    void getHorarioFechamento() {
        //given
        DiaEntity diaEntity = new DiaEntity();

        //when
        diaEntity.setHorarioFechamento("2245");

        //then
        assertEquals("22:45", diaEntity.getHorarioFechamento());
    }
    
}
