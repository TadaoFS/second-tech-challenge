package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.util.Optional;

import static com.br.second.tech.challenge.infra.config.ClockStub.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CriaUsuarioUsecaseTest {

    @Mock
    private EncriptadorGateway encriptadorGateway;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private RelogioGateway relogioGateway;

    @InjectMocks
    private CriaUsuarioUsecase criaUsuarioUsecase;

    @Test
    @DisplayName("Deve criar um idDonoRestaurante com sucesso")
    void createUser() {
        var usuarioParaCriar = UsuarioStub.criaUsuarioRegistro();
        var usuarioRetorno = UsuarioStub.criaUsuarioCompleto();

        when(relogioGateway.registrarTempo())
                .thenReturn(DATA_FIXA);
        when(encriptadorGateway.encriptar(usuarioParaCriar.senha()))
                .thenReturn("HASHED_PASSWORD");
        when(usuarioGateway.salvaUsuario(usuarioParaCriar.gerarCliente("HASHED_PASSWORD", DATA_FIXA)))
                .thenReturn(usuarioRetorno);

        var result = criaUsuarioUsecase.executar(usuarioParaCriar);

        assertThat(result).isEqualTo(usuarioRetorno);
      }

    @Test
    @DisplayName("Deve retornar erro de idDonoRestaurante ja existente")
    void createUserError() {
        var usuarioParaCriar = UsuarioStub.criaUsuarioRegistro();
        var usuarioRetorno = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorLoginOuEmail(usuarioParaCriar.login(), usuarioParaCriar.email()))
                .thenReturn(Optional.of(usuarioRetorno));

        assertThrows(RuntimeException.class, () -> criaUsuarioUsecase.executar(usuarioParaCriar));
        verify(usuarioGateway, never()). salvaUsuario(any());
        verify(encriptadorGateway, never()). encriptar(any());
    }
}