package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.domain.HorarioFuncionamento;
import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.exception.RestauranteNotFoundException;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.RestauranteRepository;
import com.br.second.tech.challenge.infra.presenter.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class RestauranteSpringDataGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;

    public RestauranteSpringDataGateway(RestauranteRepository repository) {
        this.restauranteRepository = repository;
    }

    @Override
    public void deletarRestaurante(Long id) {
        log.info("[RestauranteSpringDataGateway] Deletando restaurante com id: {}", id);
        restauranteRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurante> obterPorId(Long id) {
        log.info("[RestauranteSpringDataGateway] obterPorId: {}", id);
        return restauranteRepository.findById(id)
                .map(RestaurantePresenter::toDomain);
    }

    @Override
    public Optional<Restaurante> obterPorNome(String nome) {
        log.info("[RestauranteSpringDataGateway] obterPorNome: {}", nome);
        return restauranteRepository.findByNome(nome)
                .map(RestaurantePresenter::toDomain);
    }

    @Override
    public Optional<Restaurante> obterPorDonoRestaurante(Long idDonoRestaurante) {
        return restauranteRepository.findByUsuarioId(idDonoRestaurante)
                .map(RestaurantePresenter::toDomain);
    }

    @Override
    @Transactional
    public Restaurante criarRestaurante(Restaurante restaurante) {
        log.info("[RestauranteSpringDataGateway] Criando restaurante: {}", restaurante);
        var entity = RestaurantePresenter.toEntity(restaurante);
        var result = restauranteRepository.save(entity);
        log.info("[RestauranteSpringDataGateway] Restaurante criado com sucesso: {}", result);
        return RestaurantePresenter.toDomain(result);
    }

    @Override
    @Transactional
    public Restaurante atualizaRestaurante(Restaurante restaurante) {
        log.info("[RestauranteSpringDataGateway] Atualizando restaurante: {}", restaurante);
        var entity = restauranteRepository.findById(restaurante.id());
        if(entity.isPresent()){
            var restauranteInstance = entity.get();
            restauranteInstance.setNome(restaurante.nome());
            restauranteInstance.setTipoCozinha(restaurante.tipoCozinha());
            restauranteInstance.setEndereco(EnderecoPresenter.toEntity(restaurante.endereco(), restauranteInstance.getEndereco().getId()));
            restauranteInstance.setUsuario(UsuarioPresenter.toEntity(restaurante.usuario()));
            restauranteInstance.setDataAtualizacao(restaurante.dataAtualizacao());
            var result = restauranteRepository.save(restauranteInstance);
            log.info("[RestauranteSpringDataGateway] Restaurante atualizado no banco: {}", result.getId());
            return RestaurantePresenter.toDomain(result);
        } else {
            log.error("[RestauranteSpringDataGateway] Restaurante com ID {} não encontrado para atualização", restaurante.id());
            throw new RestauranteNotFoundException("Restaurante não encontrado para atualização");
        }
    }

    @Override
    @Transactional
    public void atualizaHorarioFuncionamento(Long idRestaurante, HorarioFuncionamento horarioFuncionamento) {
        var restaurante = restauranteRepository.findById(idRestaurante);
        if(restaurante.isPresent()){
            var restauranteOp = restaurante.get();
            restauranteOp.setHorarioFuncionamento(HorarioFuncionamentoPresenter.toEntity(horarioFuncionamento));
            var result = restauranteRepository.save(restauranteOp);
            RestaurantePresenter.toDomain(result);
        } else {
            log.error("[RestauranteSpringDataGateway] Restaurante com ID {} não encontrado para atualizar cardápio", idRestaurante);
            throw new RestauranteNotFoundException("Restaurante não encontrado para atualizar cardápio");
        }
    }
}
