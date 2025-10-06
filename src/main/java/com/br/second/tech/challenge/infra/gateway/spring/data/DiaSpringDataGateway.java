package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.gateway.DiaGateway;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.repository.DiaRepository;
import org.springframework.stereotype.Component;

@Component
public class DiaSpringDataGateway implements DiaGateway {

    private DiaRepository repository;

    public DiaSpringDataGateway(DiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiaEntity save(DiaEntity diaEntity) {
        return this.repository.save(diaEntity);
    }

    @Override
    public Boolean existsById(Long id) {
        return this.repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
