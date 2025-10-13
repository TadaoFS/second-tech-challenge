package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.Endereco;
import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.enums.TipoUsuario;
import com.br.second.tech.challenge.infra.config.ClockStub;

public class UsuarioStub {

    public static Usuario criaUsuarioRegistro(){
        return new Usuario(
                "joe@email.com",
                "joe",
                "joedue",
                "pass",
                new Endereco(
                        "999999",
                        "log1",
                        1L,
                        "bairro",
                        "cidade teste",
                        "estado"
                )
        );
    }

    public static Usuario criaUsuarioAtualizarPayload() {
        return new Usuario(
                1L,
                "joe",
                "joe@email.com",
                "joedue",
                new Endereco(
                        "999999",
                        "log1",
                        1L,
                        "bairro",
                        "cidade teste",
                        "estado"
                ));
    }

    public static Usuario criaUsuarioCompleto() {
        return new Usuario(
                1L,
                "joe",
                "joe@email.com",
                "joedue",
                "HASHED_PASSWORD",
                new Endereco(
                        1L,
                        "999999",
                        "log1",
                        1L,
                        "bairro",
                        "cidade teste",
                        "estado"
                ),
                TipoUsuario.CLIENTE,
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }

    public static Usuario criaUsuarioAntigoCompleto() {
        return new Usuario(
                1L,
                "due",
                "due@email.com",
                "duejoe",
                "HASHED_PASSWORD",
                new Endereco(
                        1L,
                        "1111",
                        "log2",
                        2L,
                        "bairro",
                        "cidade teste",
                        "estado"
                ),
                TipoUsuario.CLIENTE,
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }

    public static Usuario criaUsuarioCliente() {
        return criaUsuarioCompleto();
    }

    public static Usuario criaUsuarioDonoRestaurante() {
        return new Usuario(
                1L,
                "joe",
                "joe@email.com",
                "joedue",
                "HASHED_PASSWORD",
                new Endereco(
                        1L,
                        "999999",
                        "log1",
                        1L,
                        "bairro",
                        "cidade teste",
                        "estado"
                ),
                TipoUsuario.DONO_RESTAURANTE,
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }
}
