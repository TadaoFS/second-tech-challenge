package com.br.second.tech.challenge.core.usecase;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import org.springframework.dao.DataRetrievalFailureException;

import java.time.LocalDateTime;

public class RestauranteUseCase {

    private RestauranteGateway restauranteGateway;

    public RestauranteEntity buscarRestaurante(long id) {
        try{
            return this.restauranteGateway
                    .findById(id)
                    .orElse(null);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao buscar restaurante: " + e.getMessage());
        }

    }

    public String criarRestaurante(RestauranteEntity restaurante) {
        try {
            LocalDateTime data = LocalDateTime.now();
            restaurante.setDataCriacao(data);
            restaurante.setDataAtualizacao(data);
            RestauranteEntity restauranteSalvo = this.restauranteGateway.save(restaurante);

            return String.format("Restaurante %s criado com sucesso!", restauranteSalvo.getNome());
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao criar restaurante: " + e.getMessage());
        }
    }

    public String editarRestaurante(RestauranteEntity restaurante) {
        try {
            if (this.restauranteGateway.existsById(restaurante.getId())) {
                restaurante.setDataAtualizacao(LocalDateTime.now());
                RestauranteEntity restauranteSalvo = this.restauranteGateway.save(restaurante);
                return String.format("Restaurante %s atualizado com sucesso!", restauranteSalvo.getNome());
            }
            return "Restaurante não encontrado para atualização.";
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao atualizar restaurante: " + e.getMessage());
        }
    }

    public String deletarRestaurante(Long id) {
        try {
            if(!this.restauranteGateway.existsById(id)){
                return "Restaurante não encontrado para deleção.";
            }
            this.restauranteGateway.deleteById(id);

            return "Restaurante deletado com sucesso!";
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao deletar restaurante: " + e.getMessage());
        }
    }

}
