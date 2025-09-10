package com.br.second.tech.challenge.infra.database.repository;

import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends CrudRepository<RestauranteEntity, Long>{
}
