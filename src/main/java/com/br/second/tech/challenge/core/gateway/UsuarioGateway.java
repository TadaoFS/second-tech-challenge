package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioGateway {

    Optional<UsuarioEntity> findById(Long id);
    UsuarioEntity save(UsuarioEntity usuarioEntity);
    void deleteById(Long id);
    boolean existsById(Long id);

}
