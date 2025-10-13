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
                enderecoEntity.getEstado(),
                enderecoEntity.getDataCriacao(),
                enderecoEntity.getDataAtualizacao()
        );
    }

    public static EnderecoResponse toRespone(Endereco endereco) {
        return new EnderecoResponse(
                endereco.id(),
                endereco.cep(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.estado(),
                endereco.dataCriacao(),
                endereco.dataAtualizacao()
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
        return new EnderecoEntity(
                endereco.id(),
                endereco.cep(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.estado()
        );
    }
}
