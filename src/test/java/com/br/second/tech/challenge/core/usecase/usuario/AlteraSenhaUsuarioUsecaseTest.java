package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.core.exception.AutorizacaoIncorreta;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlteraSenhaUsuarioUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private EncriptadorGateway encriptadorGateway;

    @InjectMocks
    private AlteraSenhaUsuarioUsecase alteraSenhaUsuarioUsecase;


    @Test
    @DisplayName("Deve alterar senha do idDonoRestaurante")
    void deveAlterarSenhaDoUsuario() {
        var login = "joe";
        var senhaAntiga = "HASHED_PASSWORD";
        var senhaNova = "newPassword";
        var usuario = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorLogin(login))
                .thenReturn(Optional.of(usuario));
        when(encriptadorGateway.validarSenha(senhaAntiga, usuario.senha()))
                .thenReturn(Boolean.TRUE);

        alteraSenhaUsuarioUsecase.executar(login, senhaAntiga, senhaNova);

        verify(usuarioGateway, times(1)).alterarSenha(usuario.id(), senhaNova);
    }

    @Test
    @DisplayName("Nao deve alterar senha de idDonoRestaurante nao encontrado")
    void naoDeveAlterarSenhaDeUsuarioNaoEncontrado() {
        var login = "joe";
        var senhaAntiga = "oldPassword";
        var senhaNova = "newPassword";

        assertThrows(UsuarioNotFound.class, () -> alteraSenhaUsuarioUsecase.executar(login, senhaAntiga, senhaNova));
        verify(usuarioGateway, times(0)).alterarSenha(anyLong(), anyString());
    }

    @Test
    @DisplayName("Nao deve alterar senha de idDonoRestaurante com senha antiga invalida")
    void naoDeveAlterarSenhaDeUsuarioComSenhaAntigaInvalida() {
        var login = "joe";
        var senhaAntiga = "oldPassword";
        var senhaNova = "newPassword";
        var usuario = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorLogin(login))
                .thenReturn(Optional.of(usuario));
        when(encriptadorGateway.validarSenha(senhaAntiga, usuario.senha()))
                .thenReturn(Boolean.FALSE);

        assertThrows(AutorizacaoIncorreta.class, () -> alteraSenhaUsuarioUsecase.executar(login, senhaAntiga, senhaNova));
        verify(usuarioGateway, times(0)).alterarSenha(anyLong(), anyString());

    }
}