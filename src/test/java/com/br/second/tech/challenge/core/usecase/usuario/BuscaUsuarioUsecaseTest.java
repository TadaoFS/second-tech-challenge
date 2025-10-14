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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaUsuarioUsecaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private BuscaUsuarioUsecase buscaUsuarioUsecase;


    @Test
    @DisplayName("Deve buscar idDonoRestaurante com sucesso")
    void deveBuscarUsuarioComSucesso() {
        Long id = 1L;
        Usuario usuario = UsuarioStub.criaUsuarioCompleto();

        when(usuarioGateway.obterPorId(id))
                .thenReturn(Optional.of(usuario));

        var result = buscaUsuarioUsecase.executar(id);

        assertEquals(Boolean.TRUE, result.isPresent());
        assertThat(result)
                .get()
                .isEqualTo(usuario);
    }

    @Test
    @DisplayName("Deve retornar idDonoRestaurante nao encontrado")
    void usuarioNaoEncontrado(){
        Long id = 1L;

        when(usuarioGateway.obterPorId(id))
                .thenReturn(Optional.empty());

        assertThrows(UsuarioNotFoundException.class, () -> buscaUsuarioUsecase.executar(id));
    }
}