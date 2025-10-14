package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.exception.RestauranteNotFoundException;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.core.stub.RestauranteStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaRestauranteUsecaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;

    @InjectMocks
    private BuscaRestauranteUsecase buscaRestauranteUsecase;

    @Test
    @DisplayName("Deve buscar restaurante por ID com sucesso")
    void deveBuscarRestaurantePorIdComSucesso() {
        var restauranteId = 1L;
        var restauranteCompleto = RestauranteStub.criaRestaurante();

        when(restauranteGateway.obterPorId(restauranteId))
                .thenReturn(Optional.of(restauranteCompleto));

        var restaurante = buscaRestauranteUsecase.execute(restauranteId);

        assertThat(restaurante).isEqualTo(restauranteCompleto);
    }

    @Test
    @DisplayName("Deve lançar exceção quando restaurante não for encontrado")
    void deveLancarExcecaoQuandoRestauranteNaoForEncontrado() {
        var restauranteId = 1L;

        when(restauranteGateway.obterPorId(restauranteId))
                .thenReturn(Optional.empty());

        assertThrows(RestauranteNotFoundException.class, () -> buscaRestauranteUsecase.execute(restauranteId));
    }
}