package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Endereco;
import com.br.second.tech.challenge.infra.controller.request.EnderecoRequest;
import com.br.second.tech.challenge.infra.controller.response.EnderecoResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.EnderecoEntity;

public class EnderecoPresenter {

    public static Endereco toDomain(EnderecoEntity enderecoEntity) {
        return new Endereco(
                enderecoEntity.getId(),
                enderecoEntity.getCep(),
                enderecoEntity.getLogradouro(),
                enderecoEntity.getNumero(),
                enderecoEntity.getBairro(),
                enderecoEntity.getCidade(),
                enderecoEntity.getEstado()
        );
    }

    public static EnderecoResponse toRespone(Endereco endereco) {
        if (endereco == null) return null;
        return new EnderecoResponse(
                endereco.id(),
                endereco.cep(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.estado()
        );
    }

    public static Endereco toDomain(EnderecoRequest endereco) {
        return new Endereco(
                endereco.cep(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.estado()
        );
    }

    public static EnderecoEntity toEntity(Endereco endereco) {
        return EnderecoEntity.builder()
                .cep(endereco.cep())
                .logradouro(endereco.logradouro())
                .numero(endereco.numero())
                .bairro(endereco.bairro())
                .cidade(endereco.cidade())
                .estado(endereco.estado())
                .build();
    }
}
