package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.exception.RestauranteNotFoundException;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuscaRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscaRestauranteUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante execute(Long id) {
        log.info("[BuscaRestauranteUsecase] Iniciando busca pelo restaurante com ID: {}", id);
        var restauranteOp = restauranteGateway.obterPorId(id);
        if (restauranteOp.isPresent()) {
            var restauranteDomain = restauranteOp.get();
            log.info("[BuscaRestauranteUsecase] Restaurante encontrado: {}", restauranteDomain.nome());
            return restauranteDomain;
        } else {
            log.error("[BuscaRestauranteUsecase] Restaurante com ID {} não encontrado", id);
            throw new RestauranteNotFoundException("Restaurante {} não encontrado".replace("{}", id.toString()));
        }
    }
}
