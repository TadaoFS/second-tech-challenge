package com.br.second.tech.challenge.core.usecase;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestauranteUseCaseTest {

    RestauranteEntity restauranteEntity;

    @Mock
    RestauranteGateway restauranteGateway;

    @InjectMocks
    RestauranteUseCase restauranteUseCase;

    @BeforeEach
    void givenRestaurante(){
        restauranteEntity = new RestauranteEntity();
        restauranteEntity.setId(1L);
    }

    @Test
    @DisplayName("retorna restaurante esperado")
    void buscarRestauranteExistente() {
        //given
        givenRestaurante();
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.of(restauranteEntity));
        var restaurante = restauranteUseCase.buscarRestaurante(id);

        //then
        assertNotNull(restaurante);
        assertEquals(restauranteEntity.getId(), restaurante.getId());
    }

    @Test
    @DisplayName("não encontra restaurante")
    void buscarRestauranteNãoExistente() {
        //given
        givenRestaurante();
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.empty());
        var restaurante = restauranteUseCase.buscarRestaurante(id);

        //then
        assertNull(restaurante);
    }

    @Test
    @DisplayName("retorna erro ao buscar restaurante")
    void erroBuscarRestaurante() {
        //given

        //when
        when(restauranteGateway.findById(restauranteEntity.getId()))
                .thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.buscarRestaurante(restauranteEntity.getId()));

        //then
        assertEquals("Erro ao buscar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("cria restaurante com sucesso")
    void criarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.save(restauranteEntity)).thenReturn(restauranteEntity);
        var result = restauranteUseCase.criarRestaurante(restauranteEntity);

        //then
        assertEquals("Restaurante Restaurante Teste criado com sucesso!", result);
    }

    @Test
    @DisplayName("retorna erro ao criar restaurante")
    void erroCriarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.save(restauranteEntity)).thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () -> restauranteUseCase.criarRestaurante(restauranteEntity));

        //then
        assertEquals("Erro ao criar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("edita restaurante com sucesso")
    void editarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(true);
        when(restauranteGateway.save(restauranteEntity)).thenReturn(restauranteEntity);
        var result = restauranteUseCase.editarRestaurante(restauranteEntity);

        //then
        assertEquals("Restaurante Restaurante Teste atualizado com sucesso!", result);
    }

    @Test
    @DisplayName("não encontra restaurante para editar")
    void naoEditaRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(false);
        var result = restauranteUseCase.editarRestaurante(restauranteEntity);

        //then
        assertEquals("Restaurante não encontrado para atualização.", result);
    }

    @Test
    @DisplayName("erro ao editar restaurante")
    void erroEditaRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(true);
        when(restauranteGateway.save(restauranteEntity)).thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () -> restauranteUseCase.editarRestaurante(restauranteEntity));

        //then
        assertEquals("Erro ao atualizar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("deleta restaurante com sucesso")
    void deletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(true);
        var result = restauranteUseCase.deletarRestaurante(restauranteEntity.getId());

        //then
        assertEquals("Restaurante deletado com sucesso!", result);
    }

    @Test
    @DisplayName("não encontra restaurante para deletar")
    void naoDeletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(false);
        var result = restauranteUseCase.deletarRestaurante(restauranteEntity.getId());

        //then
        assertEquals("Restaurante não encontrado para deleção.", result);
    }

    @Test
    @DisplayName("erro ao deleta restaurante")
    void erroDeletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId()))
                .thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.deletarRestaurante(restauranteEntity.getId()));

        //then
        assertEquals("Erro ao deletar restaurante: Connection Error", exception.getMessage());
    }
}