package com.br.second.tech.challenge.core.exception;

public class UsuarioSemPermissaoException extends RuntimeException {
    public UsuarioSemPermissaoException(String msg) {
        super(msg);
    }
}
