package com.br.second.tech.challenge.infra.controller.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.usecase.restaurante.AtualizarResturanteUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.BuscaRestauranteUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.CriarResturanteUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.DeletarRestauranteUsecase;
import com.br.second.tech.challenge.infra.controller.restaurante.request.RestauranteCreateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.request.RestauranteUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.RestauranteResponse;
import com.br.second.tech.challenge.infra.presenter.RestaurantePresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
@Slf4j
public class RestauranteController {

    private final BuscaRestauranteUsecase buscarRestaurante;
    private final CriarResturanteUsecase criarResturante;
    private final AtualizarResturanteUsecase atualizarResturanteUsecase;
    private final DeletarRestauranteUsecase deletarRestaurante;

    public RestauranteController(BuscaRestauranteUsecase buscarRestaurante, CriarResturanteUsecase criarResturante, AtualizarResturanteUsecase atualizarResturanteUsecase, DeletarRestauranteUsecase deletarRestaurante) {
        this.buscarRestaurante = buscarRestaurante;
        this.criarResturante = criarResturante;
        this.atualizarResturanteUsecase = atualizarResturanteUsecase;
        this.deletarRestaurante = deletarRestaurante;
    }

    @GetMapping(value="/{id}")
    public RestauranteResponse getRestaurante(@PathVariable long id) {
        Restaurante restaurante = buscarRestaurante.execute(id);
        return RestaurantePresenter.toResponse(restaurante);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('DONO_RESTAURANTE')")
    public RestauranteResponse postRestaurante(@RequestBody RestauranteCreateRequest request) {
        var criaRequest = RestaurantePresenter.toDomain(request);
        var restaurante = criarResturante.execute(criaRequest);
        return RestaurantePresenter.toResponse(restaurante);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('DONO_RESTAURANTE')")
    public RestauranteResponse putRestaurante(@RequestBody RestauranteUpdateRequest request) {
        var updateRequest = RestaurantePresenter.toDomain(request);
        var restaurante = atualizarResturanteUsecase.execute(updateRequest);
        return RestaurantePresenter.toResponse(restaurante);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('DONO_RESTAURANTE')")
    public void deleteRestaurante(@PathVariable long id) {
        deletarRestaurante.execute(id);
    }
}
