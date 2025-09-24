package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.infra.database.entity.DiaEntity;


public interface DiaGateway {

    DiaEntity save(DiaEntity diaEntity);
    Boolean existsById(Long id);
    void deleteById(Long id);
}
