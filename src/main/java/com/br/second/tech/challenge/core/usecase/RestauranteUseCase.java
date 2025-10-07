package com.br.second.tech.challenge.core.usecase;

import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.core.gateway.DiaGateway;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.infra.presenter.RestauranteMapper;
import com.br.second.tech.challenge.infra.presenter.DiaMapper;

@Component
public class RestauranteUseCase {

    private RestauranteGateway restauranteGateway;
    private DiaGateway diaGateway;

    public RestauranteUseCase(RestauranteGateway restauranteGateway, DiaGateway diaGateway) {
        this.restauranteGateway = restauranteGateway;
        this.diaGateway = diaGateway;
    }

    public Restaurante buscarRestaurante(long id) {
        try {
            RestauranteEntity entity = this.restauranteGateway.findById(id).orElse(null);
            return RestauranteMapper.toDomain(entity);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao buscar restaurante: " + e.getMessage());
        }
    }

    public String criarRestaurante(Restaurante restaurante) {
        try {
            LocalDateTime data = LocalDateTime.now();
            restaurante.setDataCriacao(data);
            restaurante.setDataAtualizacao(data);
            RestauranteEntity entity = RestauranteMapper.toEntity(restaurante);
            RestauranteEntity restauranteSalvo = this.restauranteGateway.save(entity);
            return String.format("Restaurante %s criado com sucesso!", restauranteSalvo.getNome());
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao criar restaurante: " + e.getMessage());
        }
    }

    public String editarRestaurante(Restaurante restaurante) {
        try {
            var restauranteOriginal = this.restauranteGateway.findById(restaurante.getId());
            if (restauranteOriginal.isPresent()) {
                restaurante.setDataCriacao(restauranteOriginal.get().getDataCriacao());
                restaurante.setDataAtualizacao(LocalDateTime.now());
                RestauranteEntity entity = RestauranteMapper.toEntity(restaurante);
                RestauranteEntity restauranteSalvo = this.restauranteGateway.save(entity);
                return String.format("Restaurante %s atualizado com sucesso!", restauranteSalvo.getNome());
            }
            return "Restaurante não encontrado para atualização.";
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao atualizar restaurante: " + e.getMessage());
        }
    }

    public String deletarRestaurante(Long id) {
        try {
            if (!this.restauranteGateway.existsById(id)) {
                return "Restaurante não encontrado para deleção.";
            }
            this.restauranteGateway.deleteById(id);
            return "Restaurante deletado com sucesso!";
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao deletar restaurante: " + e.getMessage());
        }
    }

    public SemanaFuncionamento buscarSemanaFuncionamento(long id) {
        try {
            Restaurante restaurante = this.buscarRestaurante(id);
            if(restaurante == null) {
                throw new EntityNotFoundException("Restaurante não encontrado.");
            }
            return restaurante.getSemanaFuncionamento();
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao buscar os dias de funcionamento: " + e.getMessage());
        }
    }

    public Dia buscarDiaSemanaFuncionamento(long id, String dia) {
        try {
            Restaurante restaurante = this.buscarRestaurante(id);
            if(restaurante == null) {
                throw new EntityNotFoundException("Restaurante não encontrado.");
            }
            DiaEntity diaEntity = RestauranteMapper.toEntity(restaurante).getSemanaFuncionamento().buscaDiaEspecifico(dia);

            return DiaMapper.toDomain(diaEntity);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao buscar dia de funcionamento: " + e.getMessage());
        }
    }

    public String editarDiaFuncionamento(long idRestaurante, Dia dia) {
        try {
            Optional<Boolean> diaExiste = this.restauranteGateway.findById(idRestaurante)
                    .map(RestauranteEntity::getSemanaFuncionamento)
                    .map(semama -> semama
                            .buscaDiaEspecifico(dia.getNome().name())
                            .getId()
                            .equals(dia.getId()));
            if (diaExiste.equals(Optional.of(true))) {
                this.diaGateway.save(DiaMapper.toEntity(dia));
                return "Dia atualizado com sucesso!";
            }
            return "Não foi possível atualizar o dia.";
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Erro ao atualizar dia de funcionamento: " + e.getMessage());
        }
    }
}
