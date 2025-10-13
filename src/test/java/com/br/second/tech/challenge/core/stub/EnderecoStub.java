package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.Endereco;

public class EnderecoStub {
    public static Endereco criaEnderecoCompleto() {
        return new Endereco(
                1L,
                "999999",
                "log1",
                1L,
                "bairro",
                "cidade teste",
                "estado"
        );
    }
}
