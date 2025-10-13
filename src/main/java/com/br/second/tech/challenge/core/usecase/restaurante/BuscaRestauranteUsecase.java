package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.exception.RestauranteNotFound;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import org.springframework.stereotype.Service;

@Service
public class BuscaRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscaRestauranteUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante execute(Long id) {
        return restauranteGateway.findById(id)
                .orElseThrow(() -> new RestauranteNotFound(id));
    }
}
