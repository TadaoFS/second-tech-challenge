package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestauranteMapperTest {

    EnderecoEntity endereco;

    UsuarioEntity usuario;

    @Mock
    RestauranteDTO dto;

    @InjectMocks
    RestauranteMapper mapper;

    @BeforeEach
    void given(){
        usuario = new UsuarioEntity();
        endereco = new EnderecoEntity();
    }

    @Test
    @DisplayName("converte DTO para Entity")
    void toEntity() {
        //given

        //when
        when(dto.id()).thenReturn(1L);
        when(dto.nome()).thenReturn("Restaurante A");
        when(dto.tipoCozinha()).thenReturn("Italiana");
        when(dto.enderecoEntity()).thenReturn(endereco);
        when(dto.cardapioEntities()).thenReturn(List.of());
        when(dto.diasFuncionamento()).thenReturn(List.of());
        when(dto.usuario()).thenReturn(usuario);

        RestauranteEntity entity = mapper.toEntity(dto);

        //then
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("Restaurante A", entity.getNome());
        assertEquals("Italiana", entity.getTipoCozinha());
        assertEquals(endereco, entity.getEnderecoEntity());
        assertEquals(List.of(), entity.getCardapioEntities());
        assertEquals(List.of(), entity.getDiasFuncionamento());
        assertEquals(usuario, entity.getUsuario());
    }

    @Test
    @DisplayName("converte Entity para DTO")
    void toDTO() {
        //given
        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(2L);
        entity.setNome("Restaurante B");
        entity.setTipoCozinha("Japonesa");
        entity.setEnderecoEntity(endereco);
        entity.setCardapioEntities(List.of());
        entity.setDiasFuncionamento(List.of());
        entity.setUsuario(usuario);

        //when
        RestauranteDTO dto = mapper.toDTO(entity);

        //then
        assertNotNull(dto);
        assertEquals(2L, dto.id());
        assertEquals("Restaurante B", dto.nome());
        assertEquals("Japonesa", dto.tipoCozinha());
        assertEquals(endereco, dto.enderecoEntity());
        assertEquals(List.of(), dto.cardapioEntities());
        assertEquals(List.of(), dto.diasFuncionamento());
        assertEquals(usuario, dto.usuario());
    }
}