package com.br.second.tech.challenge.infra.gateway.spring.data;

import com.br.second.tech.challenge.core.exception.PratoNotFoundException;
import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.gateway.PratoGateway;
import com.br.second.tech.challenge.infra.gateway.spring.data.repository.PratoRepository;
import com.br.second.tech.challenge.infra.presenter.PratoPresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PratoSpringDataGateway implements PratoGateway {

    private final PratoRepository pratoRepository;

    public PratoSpringDataGateway(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public List<Prato> salvarPratos(List<Prato> pratos) {
        return pratoRepository.saveAll(
                pratos.stream().map(PratoPresenter::toEntity).toList()
        ).stream().map(PratoPresenter::toDomain).toList();
    }

    @Override
    public List<Prato> obterCardapio(Long idRestaurante) {
        return pratoRepository.findAllByRestauranteId(idRestaurante)
                .stream()
                .map(PratoPresenter::toDomain)
                .toList();
    }

    @Override
    public void editaPrato(Prato prato) {
        var pratoEntity = pratoRepository.findById(prato.id());
        pratoEntity.ifPresent(pratoInstance -> {
            pratoInstance.setNome(prato.nome());
            pratoInstance.setDescricao(prato.descricao());
            pratoInstance.setPreco(prato.preco());
            pratoInstance.setApenasNoLocal(prato.apenasNoLocal());
            pratoInstance.setFotoDoPrato(prato.fotoDoPrato());
            pratoInstance.setDataDeAtualizacao(prato.dataAtualizacao());
            pratoRepository.save(pratoInstance);
            log.info("[PratoSpringDataGateway.editaPrato] - Prato editado com sucesso: {}", prato.id());
        });
    }

    @Override
    public void deletaPrato(Long id) {
        pratoRepository.deleteById(id);
        log.info("[PratoSpringDataGateway.deletaPrato] - Prato deletado com sucesso: {}", id);
    }

    @Override
    public Optional<Prato> obtemPorId(Long id) {
        return pratoRepository.findById(id)
                .map(PratoPresenter::toDomain);
    }
}
