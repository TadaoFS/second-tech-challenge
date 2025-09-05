package com.br.second.tech.challenge.app.gateway.impl;

import com.br.second.tech.challenge.app.domain.entities.Restaurante;
import com.br.second.tech.challenge.app.gateway.RestauranteRepositoryGateway;
import com.br.second.tech.challenge.app.gateway.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestauranteGatewayImpl implements RestauranteRepositoryGateway {

    private final RestauranteRepository repository;

    @Autowired
    public RestauranteGatewayImpl(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Restaurante> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
