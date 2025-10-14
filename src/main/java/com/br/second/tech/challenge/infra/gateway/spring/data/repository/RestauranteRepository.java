package com.br.second.tech.challenge.infra.gateway.spring.data.repository;

import com.br.second.tech.challenge.infra.gateway.spring.data.entity.RestauranteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository extends CrudRepository<RestauranteEntity, Long>{

    Optional<RestauranteEntity> findByNome(String nome);
    Optional<RestauranteEntity> findByUsuarioId(Long idUsuario);

    Long id(Long id);
}
