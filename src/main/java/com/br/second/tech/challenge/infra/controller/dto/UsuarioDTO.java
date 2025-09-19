package com.br.second.tech.challenge.infra.controller.dto;

import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.TipoUsuarioEntity;

import java.time.LocalDateTime;

public record UsuarioDTO(

    Long id,
    String email,
    String nome,
    String sobrenome,
    String login,
    String status,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao,
    EnderecoEntity endereco,
    TipoUsuarioEntity tipoUsuario,
    RestauranteDTO restaurante

){}
