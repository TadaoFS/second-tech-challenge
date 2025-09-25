package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.repository.DiaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiaSpringDataGatewayTest {

    DiaEntity entity;

    @Mock
    private DiaRepository repository;

    @InjectMocks
    private DiaSpringDataGateway gateway;

    @BeforeEach
    void givenEntity() {
        this.entity = new DiaEntity();
        entity.setId(1L);
        entity.setNome(Dias.SEGUNDA);
        entity.setAberto(true);
        entity.setHorarioAbertura("0800");
        entity.setHorarioFechamento("1800");
    }

    @Test
    @DisplayName("salva um dia")
    void save() {
        // when
        when(repository.save(entity)).thenReturn(entity);
        DiaEntity result = gateway.save(entity);

        // then
        assertEquals(entity, result);
        verify(repository).save(entity);
    }

    @Test
    @DisplayName("retorna true quando o dia existe")
    void existsById() {
        // given
        var id = this.entity.getId();

        // when
        when(repository.existsById(id)).thenReturn(true);
        boolean exists = gateway.existsById(id);

        // then
        assertTrue(exists);
        verify(repository).existsById(id);
    }

    @Test
    @DisplayName("retorna false quando o dia não existe")
    void existsById_shouldReturnFalseWhenNotExists() {
        // given
        var id = this.entity.getId();

        // when
        when(repository.existsById(id)).thenReturn(false);
        boolean exists = gateway.existsById(id);

        // then
        assertFalse(exists);
        verify(repository).existsById(id);
    }

    @Test
    @DisplayName("deleta um dia por id")
    void deleteById() {
        // given
        var id = this.entity.getId();

        // when
        gateway.deleteById(id);

        // then
        verify(repository).deleteById(id);
    }
}
