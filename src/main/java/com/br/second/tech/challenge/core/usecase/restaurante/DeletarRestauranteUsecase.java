package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeletarRestauranteUsecase {

    private final RestauranteGateway restauranteGateway;

    public DeletarRestauranteUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public void execute(Long id) {
        log.info("[DeletarRestauranteUsecase] Iniciando deleção do restaurante com ID: {}", id);
        restauranteGateway.deletarRestaurante(id);
        log.info("[DeletarRestauranteUsecase] Restaurante com ID {} deletado com sucesso", id);
    }
}
