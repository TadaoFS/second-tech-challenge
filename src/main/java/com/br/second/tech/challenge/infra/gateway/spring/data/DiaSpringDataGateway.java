package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.gateway.DiaGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.DiaEntity;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.DiaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiaSpringDataGateway implements DiaGateway {

    private DiaRepository repository;

    @Override
    public Dia save(Dia dia) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
