package com.br.second.tech.challenge.core.exception;

public class AutorizacaoIncorreta extends RuntimeException {

    public AutorizacaoIncorreta(String falhaNaValidacaoDoUsuario) {
        super(falhaNaValidacaoDoUsuario);
    }
}
