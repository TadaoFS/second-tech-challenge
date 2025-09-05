package com.br.second.tech.challenge.app.dto;

import com.br.second.tech.challenge.app.domain.entities.Cardapio;
import com.br.second.tech.challenge.app.domain.entities.DiaFuncionamento;
import com.br.second.tech.challenge.app.domain.entities.Endereco;
import com.br.second.tech.challenge.app.domain.entities.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record RestauranteDTO(
        Long id,
        String nome,
        String tipoCozinha,
        List<DiaFuncionamento> diasFuncionamento, //TODO: Alterar para DiaFuncionamentoDTO
        Usuario usuario,
        List<Cardapio> cardapios, //TODO: Alterar para CardapioDTO
        Endereco endereco //TODO: Alterar para EnderecoDTO
) {}