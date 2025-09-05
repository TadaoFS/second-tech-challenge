package com.br.second.tech.challenge.app.usecase;

import com.br.second.tech.challenge.app.domain.entities.DiaFuncionamento;
import com.br.second.tech.challenge.app.domain.entities.Restaurante;
import com.br.second.tech.challenge.app.domain.enums.Dias;
import com.br.second.tech.challenge.app.gateway.impl.RestauranteGatewayImpl;
import org.springframework.dao.DataRetrievalFailureException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestauranteUseCase {

    private RestauranteGatewayImpl restauranteGateway;

    public Restaurante buscarRestaurante(long id) {
        return this.restauranteGateway
                .findById(id)
                .orElseThrow(() -> new DataRetrievalFailureException("Restaurante não encontrado"));
    }

    public String criarRestaurante(Restaurante restaurante) {
        try {
            LocalDateTime data = LocalDateTime.now();
            restaurante.setDataCriacao(data);
            restaurante.setDataAtualizacao(data);
            Restaurante restauranteSalvo = this.restauranteGateway.save(restaurante);

            return String.format("Restaurante %s criado com sucesso!", restauranteSalvo.getNome());
        } catch (DataRetrievalFailureException e) {
            return "Erro ao criar restaurante: " + e.getMessage();
        }
    }

    public String editarRestaurante(Restaurante restaurante) {
        try {
            if (this.restauranteGateway.existsById(restaurante.getId())) {
                restaurante.setDataAtualizacao(LocalDateTime.now());
                Restaurante restauranteSalvo = this.restauranteGateway.save(restaurante);
                return String.format("Restaurante %s atualizado com sucesso!", restauranteSalvo.getNome());
            }
           return "Restaurante não encontrado para atualização.";
        } catch (DataRetrievalFailureException e) {
            return "Erro ao atualizar restaurante: " + e.getMessage();
        }
    }

    public String deletarRestaurante(Long id) {
        try {
            this.restauranteGateway.deleteById(id);

            return "Restaurante deletado com sucesso!";
        } catch (DataRetrievalFailureException e) {
            return "Erro ao deletar restaurante: " + e.getMessage();
        }
    }

}
