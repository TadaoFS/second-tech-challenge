package com.br.second.tech.challenge.core.gateway;

import com.br.second.tech.challenge.core.domain.Restaurante;

import java.util.Optional;

public interface RestauranteGateway {

    void deletarRestaurante(Long id);
    Optional<Restaurante> obterPorId(Long id);
    Optional<Restaurante> obterPorNome(String nome);
    Optional<Restaurante> obterPorDonoRestaurante(Long idDonoRestaurante);
    Restaurante criarRestaurante(Restaurante restaurante);
    Restaurante atualizaRestaurante(Restaurante restaurante);
}
