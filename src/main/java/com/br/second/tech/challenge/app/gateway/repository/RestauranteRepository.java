package com.br.second.tech.challenge.app.gateway.repository;

import com.br.second.tech.challenge.app.domain.entities.Restaurante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{
}
