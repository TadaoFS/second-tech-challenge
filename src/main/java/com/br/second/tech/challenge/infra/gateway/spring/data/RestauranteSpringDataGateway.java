package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.RestauranteRepository;
import com.br.second.tech.challenge.infra.presenter.RestaurantePresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RestauranteSpringDataGateway implements RestauranteGateway {

    private final RestauranteRepository repository;

    public RestauranteSpringDataGateway(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Restaurante> findById(Long id) {
        return repository.findById(id)
                .map(RestaurantePresenter::toDomain);
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
