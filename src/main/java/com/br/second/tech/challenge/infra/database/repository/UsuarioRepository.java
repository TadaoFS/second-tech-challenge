package com.br.second.tech.challenge.infra.database.repository;

import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {



}
