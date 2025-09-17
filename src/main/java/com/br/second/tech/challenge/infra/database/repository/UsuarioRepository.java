package com.br.second.tech.challenge.infra.database.repository;

import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <UsuarioEntity, Long> {



}
