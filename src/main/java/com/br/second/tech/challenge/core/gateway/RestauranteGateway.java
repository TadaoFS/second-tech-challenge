package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Restaurante;

import java.util.Optional;

public interface RestauranteGateway {

    Optional<Restaurante> findById(Long id);
    Restaurante save(Restaurante restaurante);
    void deleteById(Long id);
    boolean existsById(Long id);
}
