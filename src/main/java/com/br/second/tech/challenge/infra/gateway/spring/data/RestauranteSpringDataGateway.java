package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.exception.RestauranteNotFound;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.RestauranteRepository;
import com.br.second.tech.challenge.infra.presenter.EnderecoPresenter;
import com.br.second.tech.challenge.infra.presenter.HorarioFuncionamentoPresenter;
import com.br.second.tech.challenge.infra.presenter.RestaurantePresenter;
import com.br.second.tech.challenge.infra.presenter.UsuarioPresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public Restaurante criarRestaurante(Restaurante restaurante) {
        log.info("[RestauranteSpringDataGateway] Criando restaurante: {}", restaurante);
        var entity = RestaurantePresenter.toEntity(restaurante);
        var result = restauranteRepository.save(entity);
        log.info("[RestauranteSpringDataGateway] Restaurante criado com sucesso: {}", result);
        return RestaurantePresenter.toDomain(result);
    }

    @Override
    public Restaurante atualizaRestaurante(Restaurante restaurante) {
        log.info("[RestauranteSpringDataGateway] Atualizando restaurante: {}", restaurante);
        var entity = restauranteRepository.findById(restaurante.id());
        var result = entity.map(e -> {
            e.setNome(restaurante.nome());
            e.setTipoCozinha(restaurante.tipoCozinha());
            e.setEndereco(EnderecoPresenter.toEntity(restaurante.endereco()));
            e.setUsuario(UsuarioPresenter.toEntity(restaurante.usuario()));
            e.setHorarioFuncionamento(HorarioFuncionamentoPresenter.toEntity(restaurante.horarioFuncionamento()));
            e.setDataAtualizacao(restaurante.dataAtualizacao());
            var data = restauranteRepository.save(e);
            log.info("[RestauranteSpringDataGateway] Restaurante atualizado no banco: {}", data);
            return data;
        }).orElseThrow(() -> {
            log.error("[RestauranteSpringDataGateway] Restaurante com ID {} não encontrado para atualização", restaurante.id());
            return new RestauranteNotFound("Restaurante não encontrado para atualização");
        });
        log.info("[RestauranteSpringDataGateway] Restaurante atualizado com sucesso: {}", result);
        return RestaurantePresenter.toDomain(result);
    }
}
