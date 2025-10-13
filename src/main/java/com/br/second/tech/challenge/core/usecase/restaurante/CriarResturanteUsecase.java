package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarResturanteUsecase {

    private final RestauranteGateway restauranteGateway;

    public CriarResturanteUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante execute(Restaurante restaurante) {
        return restauranteGateway.save(restaurante);
    }
}
