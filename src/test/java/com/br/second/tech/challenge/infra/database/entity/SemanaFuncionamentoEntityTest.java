package com.br.second.tech.challenge.infra.database.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SemanaFuncionamentoEntityTest {

    private SemanaFuncionamentoEntity entity;
    private DiaEntity segunda;
    private DiaEntity terca;
    private DiaEntity quarta;
    private DiaEntity quinta;
    private DiaEntity sexta;
    private DiaEntity sabado;
    private DiaEntity domingo;

    @BeforeEach
    void given() {
        segunda = createDiaEntity(Dias.SEGUNDA);
        terca = createDiaEntity(Dias.TERCA);
        quarta = createDiaEntity(Dias.QUARTA);
        quinta = createDiaEntity(Dias.QUINTA);
        sexta = createDiaEntity(Dias.SEXTA);
        sabado = createDiaEntity(Dias.SABADO);
        domingo = createDiaEntity(Dias.DOMINGO);

        entity = new SemanaFuncionamentoEntity();
        entity.setId(1L);
        entity.setSegunda(segunda);
        entity.setTerca(terca);
        entity.setQuarta(quarta);
        entity.setQuinta(quinta);
        entity.setSexta(sexta);
        entity.setSabado(sabado);
        entity.setDomingo(domingo);
        entity.setDataCriacao(LocalDateTime.now());
        entity.setDataAtualizacao(LocalDateTime.now());
    }

    private DiaEntity createDiaEntity(Dias dia) {
        return new DiaEntity(1L, dia, true, "0800", "1800",
            LocalDateTime.now(), LocalDateTime.now());
    }

    @Test
    @DisplayName("construtor vazio")
    void construtorVazio() {
        SemanaFuncionamentoEntity novaEntidade = new SemanaFuncionamentoEntity();

        assertNotNull(novaEntidade);
        assertNull(novaEntidade.getId());
        assertNull(novaEntidade.getSegunda());
        assertNull(novaEntidade.getTerca());
        assertNull(novaEntidade.getQuarta());
        assertNull(novaEntidade.getQuinta());
        assertNull(novaEntidade.getSexta());
        assertNull(novaEntidade.getSabado());
        assertNull(novaEntidade.getDomingo());
        assertNull(novaEntidade.getDataCriacao());
        assertNull(novaEntidade.getDataAtualizacao());
    }

    @Test
    @DisplayName("construtor completo")
    void construtorCompleto() {
        // Given
        LocalDateTime dataCriacao = LocalDateTime.now();
        LocalDateTime dataAtualizacao = LocalDateTime.now();

        // When
        SemanaFuncionamentoEntity novaEntidade = new SemanaFuncionamentoEntity(1L, segunda, terca,
            quarta, quinta, sexta, sabado, domingo, dataCriacao, dataAtualizacao);

        // Then
        assertEquals(1L, novaEntidade.getId());
        assertEquals(segunda, novaEntidade.getSegunda());
        assertEquals(terca, novaEntidade.getTerca());
        assertEquals(quarta, novaEntidade.getQuarta());
        assertEquals(quinta, novaEntidade.getQuinta());
        assertEquals(sexta, novaEntidade.getSexta());
        assertEquals(sabado, novaEntidade.getSabado());
        assertEquals(domingo, novaEntidade.getDomingo());
        assertEquals(dataCriacao, novaEntidade.getDataCriacao());
        assertEquals(dataAtualizacao, novaEntidade.getDataAtualizacao());
    }

    @Test
    @DisplayName("setters e getters")
    void settersEGetters() {
        // Given
        SemanaFuncionamentoEntity novaEntidade = new SemanaFuncionamentoEntity();
        LocalDateTime dataCriacao = LocalDateTime.now();
        LocalDateTime dataAtualizacao = LocalDateTime.now();

        // When
        novaEntidade.setId(1L);
        novaEntidade.setSegunda(segunda);
        novaEntidade.setTerca(terca);
        novaEntidade.setQuarta(quarta);
        novaEntidade.setQuinta(quinta);
        novaEntidade.setSexta(sexta);
        novaEntidade.setSabado(sabado);
        novaEntidade.setDomingo(domingo);
        novaEntidade.setDataCriacao(dataCriacao);
        novaEntidade.setDataAtualizacao(dataAtualizacao);

        // Then
        assertEquals(1L, novaEntidade.getId());
        assertEquals(segunda, novaEntidade.getSegunda());
        assertEquals(terca, novaEntidade.getTerca());
        assertEquals(quarta, novaEntidade.getQuarta());
        assertEquals(quinta, novaEntidade.getQuinta());
        assertEquals(sexta, novaEntidade.getSexta());
        assertEquals(sabado, novaEntidade.getSabado());
        assertEquals(domingo, novaEntidade.getDomingo());
        assertEquals(dataCriacao, novaEntidade.getDataCriacao());
        assertEquals(dataAtualizacao, novaEntidade.getDataAtualizacao());
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "segunda", "Segunda", "SEGUNDA", " segunda ", "segunda-feira",
        "terça", "terca", "Terça", "TERCA", " terca ", "terça-feira",
        "quarta", "Quarta", "QUARTA", " quarta ", "quarta-feira",
        "quinta", "Quinta", "QUINTA", " quinta ", "quinta-feira",
        "sexta", "Sexta", "SEXTA", " sexta ", "sexta-feira",
        "sábado", "sabado", "Sábado", "SABADO", " sabado ",
        "domingo", "Domingo", "DOMINGO", " domingo "
    })
    @DisplayName("busca dia especifico")
    void buscaDiaEspecifico(String nomeDia) {
        DiaEntity diaEncontrado = entity.buscaDiaEspecifico(nomeDia);

        assertNotNull(diaEncontrado);
        if (nomeDia.toLowerCase().contains("segunda")) {
            assertEquals(segunda, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("ter")) {
            assertEquals(terca, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("quarta")) {
            assertEquals(quarta, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("quinta")) {
            assertEquals(quinta, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("sexta")) {
            assertEquals(sexta, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("sab")) {
            assertEquals(sabado, diaEncontrado);
        } else if (nomeDia.toLowerCase().contains("domingo")) {
            assertEquals(domingo, diaEncontrado);
        }
    }

    @Test
    @DisplayName("busca dia especifico com dia inválido")
    void buscaDiaEspecificoComDiaInvalido() {
        // Given
        String diaInvalido = "dia inválido";

        // When
        DiaEntity resultado = entity.buscaDiaEspecifico(diaInvalido);

        // Then
        assertNull(resultado);
    }
}
