package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import com.br.second.tech.challenge.infra.database.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioSpringDataGateway implements UsuarioGateway {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioSpringDataGateway(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return repository.save(usuarioEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}





