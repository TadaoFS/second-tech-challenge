package com.br.second.tech.challenge.infra.controller.mapper;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
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
class RestauranteDTOMapperTest {

    EnderecoEntity endereco;
    SemanaFuncionamentoDTO semanaFuncionamentoDTO;
    UsuarioEntity usuario;
    Restaurante restaurante;
    @Mock
    private SemanaFuncionamentoDTOMapper semanaFuncionamentoDTOMapper;
    @Mock
    RestauranteDTO dto;
    @InjectMocks
    RestauranteDTOMapper mapper;

    @BeforeEach
    void given(){
        endereco = new EnderecoEntity();
        semanaFuncionamentoDTO = SemanaFuncionamentoDTO.builder().build();
        usuario = new UsuarioEntity();
        restaurante = new Restaurante();
        restaurante.setId(2L);
        restaurante.setNome("Restaurante B");
        restaurante.setTipoCozinha("Japonesa");
        restaurante.setEnderecoEntity(endereco);
        restaurante.setCardapioEntities(List.of());
        restaurante.setSemanaFuncionamento(null); // será mockado
        restaurante.setUsuario(usuario);
    }

    @Test
    @DisplayName("converte DTO para Domínio")
    void toDomain() {
        //given
        when(semanaFuncionamentoDTOMapper.toDomain(semanaFuncionamentoDTO)).thenReturn(null);
        //when
        when(dto.id()).thenReturn(1L);
        when(dto.nome()).thenReturn("Restaurante A");
        when(dto.tipoCozinha()).thenReturn("Italiana");
        when(dto.enderecoEntity()).thenReturn(endereco);
        when(dto.cardapioEntities()).thenReturn(List.of());
        when(dto.semanaFuncionamento()).thenReturn(semanaFuncionamentoDTO);
        when(dto.usuario()).thenReturn(usuario);
        Restaurante domain = mapper.toDomain(dto);
        //then
        assertNotNull(domain);
        assertEquals(1L, domain.getId());
        assertEquals("Restaurante A", domain.getNome());
        assertEquals("Italiana", domain.getTipoCozinha());
        assertEquals(endereco, domain.getEnderecoEntity());
        assertEquals(List.of(), domain.getCardapioEntities());
        assertNull(domain.getSemanaFuncionamento());
        assertEquals(usuario, domain.getUsuario());
        verify(semanaFuncionamentoDTOMapper).toDomain(semanaFuncionamentoDTO);
    }

    @Test
    @DisplayName("converte Domínio para DTO")
    void toDTO() {
        //given
        when(semanaFuncionamentoDTOMapper.toDTO(null)).thenReturn(semanaFuncionamentoDTO);
        //when
        RestauranteDTO dto = mapper.toDTO(restaurante);
        //then
        assertNotNull(dto);
        assertEquals(2L, dto.id());
        assertEquals("Restaurante B", dto.nome());
        assertEquals("Japonesa", dto.tipoCozinha());
        assertEquals(endereco, dto.enderecoEntity());
        assertEquals(List.of(), dto.cardapioEntities());
        assertEquals(semanaFuncionamentoDTO, dto.semanaFuncionamento());
        assertEquals(usuario, dto.usuario());
        verify(semanaFuncionamentoDTOMapper).toDTO(null);
    }
}