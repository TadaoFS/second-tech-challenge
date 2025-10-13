package com.br.second.tech.challenge.core.gateway;

public interface EncriptadorGateway {

    String encriptar(String senha);

    Boolean validarSenha(String senha, String senhaEncriptada);
}
