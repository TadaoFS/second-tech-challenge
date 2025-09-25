package com.br.second.tech.challenge.infra.database.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestauranteEntityTest {

    @Test
    @DisplayName("testa getters e setters e construtor sem argumentos")
    void getterAndSetters() {
        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(1L);
        entity.setNome("Restaurante A");
        entity.setTipoCozinha("Italiana");
        LocalDateTime now = LocalDateTime.now();
        entity.setDataCriacao(now);
        entity.setDataAtualizacao(now);
        entity.setSemanaFuncionamento(new SemanaFuncionamentoEntity());
        UsuarioEntity usuario = new UsuarioEntity();
        entity.setUsuario(usuario);
        entity.setCardapioEntities(Collections.emptyList());
        EnderecoEntity endereco = new EnderecoEntity();
        entity.setEnderecoEntity(endereco);

        assertEquals(1L, entity.getId());
        assertEquals("Restaurante A", entity.getNome());
        assertEquals("Italiana", entity.getTipoCozinha());
        assertEquals(now, entity.getDataCriacao());
        assertEquals(now, entity.getDataAtualizacao());
        assertNotNull(entity.getSemanaFuncionamento());
        assertEquals(usuario, entity.getUsuario());
        assertNotNull(entity.getCardapioEntities());
        assertEquals(endereco, entity.getEnderecoEntity());
    }
}