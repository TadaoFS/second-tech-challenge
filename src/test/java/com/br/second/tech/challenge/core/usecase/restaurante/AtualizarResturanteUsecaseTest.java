package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.exception.RestauranteNotFoundException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFoundException;
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
class AtualizarResturanteUsecaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;
    @Mock
    private UsuarioGateway usuarioGateway;
    @Mock
    private RelogioGateway relogioGateway;

    @InjectMocks
    private AtualizarResturanteUsecase atualizarResturanteUsecase;

    @Test
    @DisplayName("Deve atualizar restaurante com sucesso")
    void deveAtualizarRestauranteComSucesso() {
        var restauranteAt = RestauranteStub.criaRestauranteParaAtualizar();
        var restauranteOld = RestauranteStub.criaRestauranteAntigo();
        var restauranteAtualizado = RestauranteStub.criaRestauranteAtualizado();
        var usuarioDono = UsuarioStub.criaUsuarioDonoRestaurante();

        when(usuarioGateway.obterPorId(1L))
                .thenReturn(Optional.of(usuarioDono));

        when(restauranteGateway.obterPorId(1L))
                .thenReturn(Optional.of(restauranteOld));

        when(relogioGateway.registrarTempo())
                .thenReturn(ClockStub.DATA_FIXA);

        when(restauranteGateway.atualizaRestaurante(restauranteAt.atualiza(usuarioDono, ClockStub.DATA_FIXA)))
                .thenReturn(restauranteAtualizado);

        var result = atualizarResturanteUsecase.execute(restauranteAt);

        assertThat(result).isEqualTo(restauranteAtualizado);
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não for encontrado")
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        var restauranteAt = RestauranteStub.criaRestauranteParaAtualizar();

        when(usuarioGateway.obterPorId(1L))
                .thenReturn(Optional.empty());

        assertThrows(UsuarioNotFoundException.class, () -> atualizarResturanteUsecase.execute(restauranteAt));
    }

    @Test
    @DisplayName("Deve lançar exceção quando restaurante não for encontrado")
    void deveLancarExcecaoQuandoRestauranteNaoForEncontrado() {
        var restauranteAt = RestauranteStub.criaRestauranteParaAtualizar();
        var usuarioDono = UsuarioStub.criaUsuarioDonoRestaurante();

        when(usuarioGateway.obterPorId(1L))
                .thenReturn(Optional.of(usuarioDono));

        when(restauranteGateway.obterPorId(1L))
                .thenReturn(Optional.empty());

        assertThrows(RestauranteNotFoundException.class, () -> atualizarResturanteUsecase.execute(restauranteAt));
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não for dono de restaurante")
    void deveLancarExcecaoQuandoUsuarioNaoForDonoDeRestaurante() {
        var restauranteAt = RestauranteStub.criaRestauranteParaAtualizar();
        var usuarioComum = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorId(1L))
                .thenReturn(Optional.of(usuarioComum));

        assertThrows(UsuarioSemPermissaoException.class, () -> atualizarResturanteUsecase.execute(restauranteAt));
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário já for dono de outro restaurante")
    void deveLancarExcecaoQuandoUsuarioJaForDonoDeOutroRestaurante(){
        var restauranteAt = RestauranteStub.criaRestauranteParaAtualizar();
        var usuarioDono = UsuarioStub.criaUsuarioDonoRestaurante();
        var outroRestaurante = RestauranteStub.criaOutroRestaurante();

        when(usuarioGateway.obterPorId(1L))
                .thenReturn(Optional.of(usuarioDono));

        when(restauranteGateway.obterPorDonoRestaurante(1L))
                .thenReturn(Optional.of(outroRestaurante));

        assertThrows(UsuarioSemPermissaoException.class, () -> atualizarResturanteUsecase.execute(restauranteAt));
    }
}