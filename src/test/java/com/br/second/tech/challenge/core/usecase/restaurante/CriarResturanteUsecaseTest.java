package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.exception.RestauranteJaExistenteException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.exception.UsuarioSemPermissaoException;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.core.stub.RestauranteStub;
import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.infra.config.ClockStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CriarResturanteUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;
    @Mock
    private RestauranteGateway restauranteGateway;
    @Mock
    private RelogioGateway relogioGateway;

    @InjectMocks
    private CriarResturanteUsecase criarResturanteUsecase;

    @Test
    @DisplayName("Deve criar um restaurante com sucesso")
    void deveCriarRestauranteComSucesso() {
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();
        var restauranteRequest = RestauranteStub.criaRequest(donoRestaurante);
        var restauranteEsperado = RestauranteStub.criaRestaurante(donoRestaurante);

        when(usuarioGateway.obterPorId(donoRestaurante.id()))
                .thenReturn(Optional.of(donoRestaurante));

        when(restauranteGateway.obterPorNome(restauranteRequest.nome()))
                .thenReturn(Optional.empty());

        when(relogioGateway.registrarTempo())
                .thenReturn(ClockStub.DATA_FIXA);

        when(restauranteGateway.criarRestaurante(restauranteRequest.criar(ClockStub.DATA_FIXA, donoRestaurante)))
                .thenReturn(restauranteEsperado);

        var restauranteCriado = criarResturanteUsecase.execute(restauranteRequest);

        assertThat(restauranteCriado).isEqualTo(restauranteEsperado);
    }

    @Test
    @DisplayName("Deve lancar excecao quando o usuario nao for encontrado")
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();
        var restauranteRequest = RestauranteStub.criaRequest(donoRestaurante);

        when(usuarioGateway.obterPorId(donoRestaurante.id()))
                .thenReturn(Optional.empty());

        assertThrows(UsuarioNotFound.class, () -> criarResturanteUsecase.execute(restauranteRequest));
    }

    @Test
    @DisplayName("Deve lancar excecao quando o usuario nao for dono de restaurante")
    void deveLancarExcecaoQuandoUsuarioNaoForDonoDeRestaurante() {
        var usuarioComum = UsuarioStub.criaUsuarioCliente();
        var restauranteRequest = RestauranteStub.criaRequest(usuarioComum);

        when(usuarioGateway.obterPorId(usuarioComum.id()))
                .thenReturn(Optional.of(usuarioComum));

        assertThrows(UsuarioSemPermissaoException.class, () -> criarResturanteUsecase.execute(restauranteRequest));
    }

    @Test
    @DisplayName("Deve lancar excecao quando o restaurante ja existir")
    void deveLancarExcecaoQuandoRestauranteJaExistir() {
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();
        var restauranteRequest = RestauranteStub.criaRequest(donoRestaurante);
        var restauranteExistente = RestauranteStub.criaRestaurante(donoRestaurante);

        when(usuarioGateway.obterPorId(donoRestaurante.id()))
                .thenReturn(Optional.of(donoRestaurante));

        when(restauranteGateway.obterPorNome(restauranteRequest.nome()))
                .thenReturn(Optional.of(restauranteExistente));

        assertThrows(RestauranteJaExistenteException.class, () -> criarResturanteUsecase.execute(restauranteRequest));
    }

    @Test
    @DisplayName("Deve lancar excecao quando o usuario ja possuir um restaurante")
    void deveLancarExcecaoQuandoUsuarioJaPossuirUmRestaurante() {
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();
        var restauranteRequest = RestauranteStub.criaRequest(donoRestaurante);
        var restauranteExistente = RestauranteStub.criaRestaurante(donoRestaurante);

        when(usuarioGateway.obterPorId(donoRestaurante.id()))
                .thenReturn(Optional.of(donoRestaurante));

        when(restauranteGateway.obterPorDonoRestaurante(donoRestaurante.id()))
                .thenReturn(Optional.of(restauranteExistente));

        assertThrows(UsuarioSemPermissaoException.class, () -> criarResturanteUsecase.execute(restauranteRequest));
    }
}