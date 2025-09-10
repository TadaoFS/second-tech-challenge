package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.database.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestauranteSpringDataGateway implements RestauranteGateway {

    private final RestauranteRepository repository;

    @Autowired
    public RestauranteSpringDataGateway(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<RestauranteEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public RestauranteEntity save(RestauranteEntity restauranteEntity) {
        return repository.save(restauranteEntity);
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
