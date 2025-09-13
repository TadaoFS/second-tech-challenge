package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;

import java.util.Optional;

public interface RestauranteGateway {

    Optional<RestauranteEntity> findById(Long id);
    RestauranteEntity save(RestauranteEntity restauranteEntity);
    void deleteById(Long id);
    boolean existsById(Long id);

}
