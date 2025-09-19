package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.infra.database.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestauranteSpringDataGatewayTest {

    RestauranteEntity entity;

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private RestauranteSpringDataGateway gateway;

    @BeforeEach
    void givenEntity(){
        this.entity = new RestauranteEntity();
        entity.setId(1L);
    }

    @Test
    @DisplayName("retorna um restaurante por id")
    void findById() {
        //given
        var id = this.entity.getId();

        //when
        when(repository.findById(id)).thenReturn(Optional.of(entity));
        Optional<RestauranteEntity> result = gateway.findById(id);

        //then
        assertTrue(result.isPresent());
        assertEquals(entity, result.get());
        verify(repository).findById(id);
    }

    @Test
    @DisplayName("retorna empty restaurante por id")
    void findById_empty() {
        //given
        var id = this.entity.getId();

        //when
        when(repository.findById(id)).thenReturn(Optional.empty());
        Optional<RestauranteEntity> result = gateway.findById(id);

        //then
        assertTrue(result.isEmpty());
        verify(repository).findById(id);
    }

    @Test
    @DisplayName("salva um restaurante")
    void save() {
        //given

        //when
        when(repository.save(entity)).thenReturn(entity);
        RestauranteEntity result = gateway.save(entity);

        //then
        assertEquals(entity, result);
        verify(repository).save(entity);
    }

    @Test
    @DisplayName("deleta um restaurante por id")
    void deleteById() {
        //given
        var id = this.entity.getId();

        //when
        gateway.deleteById(id);

        //then
        verify(repository).deleteById(id);
    }

    @Test
    @DisplayName("retorna true quando o restaurante existe")
    void existsById() {
        //given
        var id = this.entity.getId();

        //when
        when(repository.existsById(id)).thenReturn(true);
        boolean exists = gateway.existsById(id);

        //then
        assertTrue(exists);
        verify(repository).existsById(id);
    }

    @Test
    @DisplayName("retorna false quando o restaurante não existe")
    void existsById_shouldReturnFalseWhenNotExists() {
        //given
        var id = this.entity.getId();

        //when
        when(repository.existsById(id)).thenReturn(false);
        boolean exists = gateway.existsById(id);

        //then
        assertFalse(exists);
        verify(repository).existsById(id);
    }
}