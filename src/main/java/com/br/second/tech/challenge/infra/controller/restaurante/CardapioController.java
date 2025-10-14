package com.br.second.tech.challenge.infra.controller.restaurante;

import com.br.second.tech.challenge.core.usecase.restaurante.prato.BuscaCardapioUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.prato.CriaCardapioUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.prato.EditaPratoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.prato.RemovePratoUsecase;
import com.br.second.tech.challenge.infra.controller.restaurante.request.CardapioRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.request.PratoRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.request.PratoUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.CardapioResponse;
import com.br.second.tech.challenge.infra.presenter.CardapioPresenter;
import com.br.second.tech.challenge.infra.presenter.PratoPresenter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1/restaurante/{idRestaurante}/cardapio")
public class CardapioController {

    private final CriaCardapioUsecase criaCardapioUsecase;
    private final BuscaCardapioUsecase buscaCardapioUsecase;
    private final EditaPratoUsecase editaPratoUsecase;
    private final RemovePratoUsecase removePratoUsecase;

    public CardapioController(CriaCardapioUsecase criaCardapioUsecase, BuscaCardapioUsecase buscaCardapioUsecase, EditaPratoUsecase editaPratoUsecase, RemovePratoUsecase removePratoUsecase) {
        this.criaCardapioUsecase = criaCardapioUsecase;
        this.buscaCardapioUsecase = buscaCardapioUsecase;
        this.editaPratoUsecase = editaPratoUsecase;
        this.removePratoUsecase = removePratoUsecase;
    }

    @GetMapping
    public CardapioResponse obterCardapio(@PathVariable Long idRestaurante){
        log.info("[CardapioController] - Iniciando busca de cardapio do restaurante {}", idRestaurante);
        var pratos = buscaCardapioUsecase.executar(idRestaurante);
        log.info("[CardapioController] - Cardapio do restaurante {} encontrado com sucesso", idRestaurante);
        return CardapioPresenter.toResponse(pratos);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DONO_RESTAURANTE')")
    public CardapioResponse criaCardapio(@PathVariable Long idRestaurante, @RequestBody @Valid CardapioRequest request){
        log.info("[CardapioController] criando cardapio para o restaurante {}", idRestaurante);
        var pratoDomain = PratoPresenter.toDomain(request.cardapio(), idRestaurante);
        var result = criaCardapioUsecase.executar(idRestaurante, pratoDomain);
        return CardapioPresenter.toResponse(result);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DONO_RESTAURANTE')")
    public void editaPrato(@PathVariable Long idRestaurante, @RequestBody @Valid PratoUpdateRequest request){
        log.info("[CardapioController] - atualizando prato do restaurante {}", idRestaurante);
        var pratoDomain = PratoPresenter.toDomain(request, idRestaurante);
        editaPratoUsecase.executar(pratoDomain);
        log.info("[CardapioController] - prato do restaurante {} atualizado com sucesso", idRestaurante);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DONO_RESTAURANTE')")
    public void removePrato(@PathVariable Long idRestaurante, @PathVariable Long id){
        log.info("[CardapioController] - removendo prato do restaurante {}", idRestaurante);
        removePratoUsecase.executar(id);
        log.info("[CardapioController] - prato do restaurante {} removido com sucesso", idRestaurante);
    }
}
