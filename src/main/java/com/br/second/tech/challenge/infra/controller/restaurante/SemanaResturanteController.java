package com.br.second.tech.challenge.infra.controller.restaurante;

import com.br.second.tech.challenge.core.usecase.restaurante.semana.AtualizaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.semana.BuscaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.semana.BuscaSemanaFuncionamentoUsecase;
import com.br.second.tech.challenge.infra.controller.restaurante.request.DiaRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.DiaResponse;
import com.br.second.tech.challenge.infra.controller.restaurante.response.SemanaFuncionamentoResponse;
import com.br.second.tech.challenge.infra.presenter.DiaPresenter;
import com.br.second.tech.challenge.infra.presenter.SemanaFuncionamentoPresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante/{idRestaurante}/semana-funcionamento")
@Slf4j
public class SemanaResturanteController {


    private BuscaDiaFuncionamentoUsecase buscaRestauranteDiaFuncionamentoUsecase;
    private BuscaSemanaFuncionamentoUsecase buscarSemanaFuncionamentoUsecase;
    private AtualizaDiaFuncionamentoUsecase atualizaDiaFuncionamentoUsecase;

    @GetMapping(value="/{dia}")
    public DiaResponse getDiaFuncionamento(@PathVariable long idRestaurante, @PathVariable String dia) {
        var result = buscaRestauranteDiaFuncionamentoUsecase.execute(idRestaurante, dia);
        return DiaPresenter.toResponse(result);
    }

    @GetMapping
    public SemanaFuncionamentoResponse getSemanaFuncionamento(@PathVariable long idRestaurante) {
        var result = buscarSemanaFuncionamentoUsecase.execute(idRestaurante);
        return SemanaFuncionamentoPresenter.toResponse(result);
    }

    @PutMapping
    public DiaResponse putDiaSemanaFuncionamento(@PathVariable long idRestaurante, @RequestBody DiaRequest diaReq) {
        var result = this.atualizaDiaFuncionamentoUsecase.execute(idRestaurante, DiaPresenter.toDomain(diaReq));
        return DiaPresenter.toResponse(result);
    }
}
