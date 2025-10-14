package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Prato;

import java.util.List;
import java.util.Optional;

public interface PratoGateway {

    List<Prato> salvarPratos(List<Prato> pratos);
    List<Prato> obterCardapio(Long idRestaurante);
    void editaPrato(Prato prato);
    void deletaPrato(Long id);
    Optional<Prato> obtemPorId(Long id);
}
