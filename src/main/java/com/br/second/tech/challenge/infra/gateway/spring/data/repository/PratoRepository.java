package com.br.second.tech.challenge.infra.gateway.spring.data.repository;

import com.br.second.tech.challenge.infra.gateway.spring.data.entity.PratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<PratoEntity, Long> {

    List<PratoEntity> findAllByRestauranteId(Long idRestaurante);
}
