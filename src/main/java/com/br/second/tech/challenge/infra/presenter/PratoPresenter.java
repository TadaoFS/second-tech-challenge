package com.br.second.tech.challenge.infra.presenter;

import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.infra.controller.restaurante.request.PratoRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.request.PratoUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.PratoResponse;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.PratoEntity;
import com.br.second.tech.challenge.infra.gateway.spring.data.entity.RestauranteEntity;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PratoPresenter {

    public static List<PratoEntity> toEntity(List<Prato> pratos) {
        return pratos.stream().map(PratoPresenter::toEntity)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static PratoEntity toEntity(Prato prato) {
        return new PratoEntity(
                prato.nome(),
                prato.descricao(),
                prato.preco(),
                prato.apenasNoLocal(),
                prato.fotoDoPrato(),
                new RestauranteEntity(prato.restaurante().id()),
                prato.dataCriacao()
        );
    }

    public static Prato toDomain(PratoEntity pratoEntity) {
        return new Prato(
                pratoEntity.getId(),
                pratoEntity.getNome(),
                pratoEntity.getDescricao(),
                pratoEntity.getPreco(),
                pratoEntity.getApenasNoLocal(),
                pratoEntity.getFotoDoPrato(),
                RestaurantePresenter.toDomain(pratoEntity),
                pratoEntity.getDataDeAtualizacao(),
                pratoEntity.getDataDeAtualizacao()
        );
    }

    public static List<Prato> toDomain(List<PratoRequest> cardapio) {
        return cardapio.stream().map(PratoPresenter::toDomain).toList();
    }

    private static Prato toDomain(PratoRequest pratoRequest) {
        return new Prato(
                pratoRequest.nome(),
                pratoRequest.descricao(),
                pratoRequest.preco(),
                pratoRequest.apenasNoLocal(),
                pratoRequest.fotoDoPrato()
        );
    }

    public static List<PratoResponse> toResponse(List<Prato> result) {
        if (result == null) return null;
        return result.stream().map(PratoPresenter::toResponse).toList();
    }

    public static PratoResponse toResponse(Prato result) {
        return new PratoResponse(
                result.id(),
                result.nome(),
                result.descricao(),
                result.preco(),
                result.apenasNoLocal(),
                result.fotoDoPrato(),
                result.dataCriacao(),
                result.dataAtualizacao()
        );
    }

    public static List<Prato> toDomain(List<PratoRequest> cardapio, Long idRestaurante) {
        return cardapio.stream()
                .map(pratoRequest -> new Prato(
                pratoRequest.nome(),
                pratoRequest.descricao(),
                pratoRequest.preco(),
                pratoRequest.apenasNoLocal(),
                pratoRequest.fotoDoPrato(),
                idRestaurante
        )).toList();
    }

    public static List<PratoEntity> toEntity(List<Prato> cardapio, RestauranteEntity restauranteOp) {
        return cardapio.stream().map(
                prato -> new PratoEntity(
                        prato.nome(),
                        prato.descricao(),
                        prato.preco(),
                        prato.apenasNoLocal(),
                        prato.fotoDoPrato(),
                        restauranteOp,
                        prato.dataCriacao()
                )
        ).toList();
    }

    public static Prato toDomain(PratoUpdateRequest request, Long idRestaurante) {
        return new Prato(
                request.id(),
                request.nome(),
                request.descricao(),
                request.preco(),
                request.apenasNoLocal(),
                request.fotoDoPrato(),
                new Restaurante(idRestaurante)
        );
    }
}
