package com.br.second.tech.challenge.infra.gateway.spring.data.repository;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByLogin(String username);

    Optional<UsuarioEntity> findByLoginOrEmail(String login, String email);
}
