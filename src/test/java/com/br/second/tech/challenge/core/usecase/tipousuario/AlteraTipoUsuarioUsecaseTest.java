package com.br.second.tech.challenge.core.usecase.tipousuario;

import com.br.second.tech.challenge.core.domain.UsuarioStub;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import com.br.second.tech.challenge.infra.config.ClockStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlteraTipoUsuarioUsecaseTest {

    @Mock
    private Clock clock;

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private AlteraTipoUsuarioUsecase alteraTipoUsuarioUsecase;


    @BeforeEach
    void setUp() {
        when(clock.instant()).thenReturn(ClockStub.INSTANT);
        when(clock.getZone()).thenReturn(ClockStub.ZONA);
    }

    @Test
    @DisplayName("Deve alterar tipo de usuario com sucesso")
    void deveAlterarTipoDeUsuarioComSucesso(){
        Long id = 1L;
        String novoTipo = "DONO_RESTAURANTE";
        var cliente = UsuarioStub.criaUsuarioCliente();
        var donoRestaurante = UsuarioStub.criaUsuarioDonoRestaurante();

        when(usuarioGateway.obterPorId(id))
                .thenReturn(Optional.of(cliente));

        alteraTipoUsuarioUsecase.executar(id, novoTipo);

        verify(usuarioGateway, times(1)).atualizaUsuario(donoRestaurante);
    }
}