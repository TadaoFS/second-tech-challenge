package com.br.second.tech.challenge.core.exception;

public class RestauranteNotFound extends RuntimeException {

    public RestauranteNotFound(Long id) {
        super("Restaurante com ID " + id + " não encontrado.");
    }
}
