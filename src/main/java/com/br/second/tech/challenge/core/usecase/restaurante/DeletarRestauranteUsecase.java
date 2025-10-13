package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import org.springframework.stereotype.Service;

@Service
public class DeletarRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public DeletarRestauranteUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public void execute(Long id) {
        restauranteGateway.deleteById(id);
    }
}
