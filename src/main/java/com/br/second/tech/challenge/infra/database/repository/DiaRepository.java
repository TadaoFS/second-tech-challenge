package com.br.second.tech.challenge.infra.database.repository;

import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends CrudRepository<DiaEntity, Long> {
}
