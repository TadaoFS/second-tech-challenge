package com.br.second.tech.challenge.core.usecase.tipousuario;

import com.br.second.tech.challenge.core.exception.TipoUsuarioNotFound;
import com.br.second.tech.challenge.core.exception.UsuarioNotFoundException;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.infra.config.ClockStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlteraTipoUsuarioUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;
    @Mock
    private RelogioGateway relogioGateway;
    @InjectMocks
    private AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase;


    @Test
    @DisplayName("Deve alterar tipo de idDonoRestaurante com sucesso")
    void deveAlterarTipoDeUsuarioComSucesso(){
        Long id = 1L;
        String novoTipo = "DONO_RESTAURANTE";
        var cliente = UsuarioStub.criaUsuarioCliente();
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();

        when(relogioGateway.registrarTempo())
                .thenReturn(ClockStub.DATA_FIXA);
        when(usuarioGateway.obterPorId(id))
                .thenReturn(Optional.of(cliente));

        alteraTipoUsuarioUsecase.executar(id, novoTipo);

        verify(usuarioGateway, times(1)).alteraTipoUsuario(donoRestaurante);
    }

    @Test
    @DisplayName("Deve lancar excecao quando idDonoRestaurante nao for encontrado")
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado(){
        Long id = 1L;
        String novoTipo = "DONO_RESTAURANTE";

        assertThrows(UsuarioNotFoundException.class, () -> alteraTipoUsuarioUsecase.executar(id, novoTipo));
        verify(usuarioGateway, never()).atualizaUsuario(any());
    }

    @Test
    @DisplayName("Deve lancar excecao quando tipo de idDonoRestaurante for invalido")
    void deveLancarExcecaoQuandoTipoDeUsuarioForInvalido(){
        Long id = 1L;
        String novoTipo = "TIPO_INVALIDO";
        var cliente = UsuarioStub.criaUsuarioCliente();

        when(usuarioGateway.obterPorId(id))
                .thenReturn(Optional.of(cliente));

        assertThrows(TipoUsuarioNotFound.class, () -> alteraTipoUsuarioUsecase.executar(id, novoTipo));
        verify(usuarioGateway, never()).atualizaUsuario(any());
    }
}