package com.br.second.tech.challenge.core.gateway;

public interface AutorizacaoGateway {

    Boolean validarLogin(String login, String senha);
}
