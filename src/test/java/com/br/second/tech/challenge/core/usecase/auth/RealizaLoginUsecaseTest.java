package com.br.second.tech.challenge.core.usecase.auth;

import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.core.exception.AutorizacaoLoginErro;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.TokenGateawy;
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
class RealizaLoginUsecaseTest {

    @Mock
    private EncriptadorGateway encriptadorGateway;
    @Mock
    private TokenGateawy tokenGateawy;
    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private RealizaLoginUsecase realizaLoginUsecase;

    @Test
    @DisplayName("Deve gerar token com sucesso")
    void gerarToken(){
        var userRequest = "joe";
        var userPassword = "pass123";
        var user = UsuarioStub.criaUsuarioCompleto();
        var tokenExpect = "TOKEN_EXPECTED";

        when(usuarioGateway.obterPorLogin(userRequest))
                .thenReturn(Optional.of(user));
        when(encriptadorGateway.validarSenha(userPassword, user.senha()))
                .thenReturn(Boolean.TRUE);
        when(tokenGateawy.generateToken(user))
                .thenReturn(tokenExpect);

        var result = realizaLoginUsecase.execute(userRequest, userPassword);

        assertNotNull(result);
        assertEquals(tokenExpect, result);
    }

    @Test
    @DisplayName("Deve retornar idDonoRestaurante nao encontrado")
    void usuarioNaoEncontrado(){
        var userRequest = "joe";
        var userPassword = "pass123";
        assertThrows(AutorizacaoLoginErro.class, () -> realizaLoginUsecase.execute(userRequest, userPassword));
    }

    @Test
    @DisplayName("Deve retornar falha na validacao da senha")
    void falhaNaValidacaoSenha(){
        var userRequest = "joe";
        var userPassword = "";
        var user = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorLogin(userRequest))
                .thenReturn(Optional.of(user));
        when(encriptadorGateway.validarSenha(userPassword, user.senha()))
                .thenReturn(Boolean.FALSE);
        assertThrows(AutorizacaoLoginErro.class, () -> realizaLoginUsecase.execute(userRequest, userPassword));
    }
}