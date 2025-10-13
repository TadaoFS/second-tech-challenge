package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.UsuarioStub;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CriaUsuarioUsecaseTest {

    @Mock
    private EncriptadorGateway encriptadorGateway;

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private CriaUsuarioUsecase criaUsuarioUsecase;

    @Test
    @DisplayName("Deve criar um usuario com sucesso")
    void createUser() {
        var usuarioParaCriar = UsuarioStub.criaUsuarioRegistro();
        var usuarioRetorno = UsuarioStub.criaUsuarioCompleto();

        when(encriptadorGateway.encriptar(usuarioParaCriar.senha()))
                .thenReturn("HASHED_PASSWORD");

        when(usuarioGateway.salvaUsuario(usuarioParaCriar.gerarCliente("HASHED_PASSWORD")))
                .thenReturn(usuarioRetorno);

        var result = criaUsuarioUsecase.executar(usuarioParaCriar);

        assertEquals(usuarioRetorno.id(), result.id());
        assertEquals(usuarioRetorno.nome(), result.nome());
        assertEquals(usuarioRetorno.email(), result.email());
        assertEquals(usuarioRetorno.login(), result.login());
        assertEquals(usuarioRetorno.senha(), result.senha());
        assertEquals(usuarioRetorno.tipoUsuario(), result.tipoUsuario());
        assertEquals(usuarioRetorno.endereco().id(), result.endereco().id());
        assertEquals(usuarioRetorno.endereco().logradouro(), result.endereco().logradouro());
    }

    @Test
    @DisplayName("Deve retornar erro de usuario ja existente")
    void createUserError() {
        var usuarioParaCriar = UsuarioStub.criaUsuarioRegistro();
        var usuarioRetorno = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorLoginOuEmail(usuarioParaCriar.login(), usuarioParaCriar.email()))
                .thenReturn(Optional.of(usuarioRetorno));

        assertThrows(RuntimeException.class, () -> criaUsuarioUsecase.executar(usuarioParaCriar));
    }
}