package com.br.second.tech.challenge.core.stub;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.infra.config.ClockStub;

public class RestauranteStub {
    public static Restaurante criaRequest(Usuario donoRestaurante) {
        return new Restaurante(
                "Restaurante do Joe",
                "Italiana",
                HorarioFuncionamentoStub.criaHorarioFuncionamentoPadrao(),
                donoRestaurante.id(),
                EnderecoStub.criaEnderecoCompleto()
        );
    }

    public static Restaurante criaRestaurante(Usuario donoRestaurante) {
        return new Restaurante(
                1L,
                "Restaurante do Joe",
                "Italiana",
                HorarioFuncionamentoStub.criaHorarioFuncionamentoPadrao(),
                donoRestaurante,
                EnderecoStub.criaEnderecoCompleto(),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }

    public static Restaurante criaRestaurante() {
        return criaRestaurante(UsuarioStub.criaUsuarioDonoRestaurante());
    }

    public static Restaurante criaRestauranteParaAtualizar() {
        return new Restaurante(
                1L,
                "Restaurante do Joe Atualizado",
                "Italiana Plus",
                null,
                1L,
                EnderecoStub.criaEnderecoCompleto()
        );
    }


    public static Restaurante criaRestauranteAtualizado() {
        return new Restaurante(
                1L,
                "Restaurante do Joe Atualizado",
                "Italiana Plus",
                HorarioFuncionamentoStub.criaHorarioFuncionamentoPadrao(),
                UsuarioStub.criaUsuarioDonoRestaurante(),
                EnderecoStub.criaEnderecoCompleto(),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }

    public static Restaurante criaRestauranteAntigo() {
        return new Restaurante(
                1L,
                "Restaurante do Joe",
                "Italiana",
                HorarioFuncionamentoStub.criaHorarioFuncionamentoPadrao(),
                UsuarioStub.criaUsuarioDonoRestaurante(),
                EnderecoStub.criaEnderecoCompleto(),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }

    public static Restaurante criaOutroRestaurante() {
        return new Restaurante(
                2L,
                "Restaurante do Joe Atualizado",
                "Italiana Plus Plus",
                HorarioFuncionamentoStub.criaHorarioFuncionamentoPadrao(),
                UsuarioStub.criaUsuarioDonoRestaurante(),
                EnderecoStub.criaEnderecoCompleto(),
                ClockStub.DATA_FIXA,
                ClockStub.DATA_FIXA
        );
    }
}
