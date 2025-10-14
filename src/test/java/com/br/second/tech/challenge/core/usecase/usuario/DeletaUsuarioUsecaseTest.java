package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.stub.UsuarioStub;
import com.br.second.tech.challenge.core.exception.UsuarioNotFoundException;
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
class DeletaUsuarioUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private DeletaUsuarioUsecase deletaUsuarioUsecase;

    @Test
    @DisplayName("Deve deletar um usuário com sucesso")
    void deveDeletarUmUsuarioComSucesso(){
        Long usuarioId = 1L;
        Usuario usuario = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorId(usuarioId))
                .thenReturn(Optional.of(usuario));

        assertDoesNotThrow(() -> deletaUsuarioUsecase.executar(usuarioId));

        verify(usuarioGateway, times(1)).removeUsuario(usuarioId);
    }

    @Test
    @DisplayName("Nao deve deletar um idDonoRestaurante nao encontrado")
    void naoDeveDeletarUmUsuarioNaoEncontrado(){
        Long usuarioId = 1L;

        assertThrows(UsuarioNotFoundException.class, () -> deletaUsuarioUsecase.executar(usuarioId));

        verify(usuarioGateway, times(0)).removeUsuario(usuarioId);
    }
}