package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.UsuarioStub;
import com.br.second.tech.challenge.core.exception.UsuarioExistenteException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtualizaUsuarioUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private AtualizaUsuarioUsecase atualizaUsuarioUsecase;


    @Test
    @DisplayName("Deve atualizar um usuario com sucesso")
    void deveAtualizarUmUsuarioComSucesso() {
        var usuario = UsuarioStub.criaUsuarioAtualizarPayload();
        var usuarioAntigo = UsuarioStub.criaUsuarioAntigoCompleto();
        var usuarioExpected = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorId(usuario.id()))
                .thenReturn(Optional.of(usuarioAntigo));
        when(usuarioGateway.atualizaUsuario(usuario))
                .thenReturn(usuarioExpected);

        var result = atualizaUsuarioUsecase.executar(usuario);

        assertEquals(usuarioExpected.id(), result.id());
        assertEquals(usuarioExpected.nome(), result.nome());
        assertEquals(usuarioExpected.email(), result.email());
        assertEquals(usuarioExpected.login(), result.login());
        assertEquals(usuarioExpected.senha(), result.senha());
        assertEquals(usuarioExpected.tipoUsuario(), result.tipoUsuario());
        assertEquals(usuarioExpected.endereco().id(), result.endereco().id());
        assertEquals(usuarioExpected.endereco().logradouro(), result.endereco().logradouro());
    }

    @Test
    @DisplayName("Nao deve atualizar usuario nao encontrado")
    void naoDeveAtualizarUsuarioNaoEncontrado() {
        var usuario = UsuarioStub.criaUsuarioAtualizarPayload();

        when(usuarioGateway.obterPorId(usuario.id()))
                .thenReturn(Optional.empty());

        assertThrows(UsuarioNotFound.class, () -> atualizaUsuarioUsecase.executar(usuario));
        verify(usuarioGateway, times(0)).atualizaUsuario(usuario);
    }

    @Test
    @DisplayName("Nao deve atualizar usuario ja existente")
    void naoDeveAtualizarUsuarioJaExistente() {
        var usuario = UsuarioStub.criaUsuarioAtualizarPayload();
        var usuarioExistente = UsuarioStub.criaUsuarioCompleto();
        var usuarioAntigo = UsuarioStub.criaUsuarioAntigoCompleto();

        when(usuarioGateway.obterPorId(usuario.id()))
                .thenReturn(Optional.of(usuarioAntigo));
        when(usuarioGateway.obterPorLoginOuEmail(usuario.login(), usuario.email()))
                .thenReturn(Optional.of(usuarioExistente));

        assertThrows(UsuarioExistenteException.class, () -> atualizaUsuarioUsecase.executar(usuario));
        verify(usuarioGateway, times(0)).atualizaUsuario(usuario);
    }
}