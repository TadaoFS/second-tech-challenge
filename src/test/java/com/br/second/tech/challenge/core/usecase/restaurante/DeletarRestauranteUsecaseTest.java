package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeletarRestauranteUsecaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;

    @InjectMocks
    private  DeletarRestauranteUsecase deletarRestauranteUsecase;

    @Test
    @DisplayName("Deve deletar restaurante com sucesso")
    void deveDeletarRestauranteComSucesso() {
        assertDoesNotThrow(() -> deletarRestauranteUsecase.execute(1L));
    }
}