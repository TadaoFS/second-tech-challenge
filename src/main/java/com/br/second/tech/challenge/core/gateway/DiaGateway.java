package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Dia;


public interface DiaGateway {

    Dia save(Dia dia);
    Boolean existsById(Long id);
    void deleteById(Long id);
}
