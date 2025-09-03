package com.br.second.tech.challenge.app.gateway;

import com.br.second.tech.challenge.app.domain.entities.Restaurante;

import java.util.Optional;

public interface RestauranteRepositoryGateway {

    Optional<Restaurante> findById(Long id);
    Restaurante save(Restaurante restaurante);
    void deleteById(Long id);
    boolean existsById(Long id);

}
