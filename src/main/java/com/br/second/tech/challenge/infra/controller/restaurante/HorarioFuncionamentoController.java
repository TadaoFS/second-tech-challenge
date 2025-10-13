package com.br.second.tech.challenge.infra.controller.restaurante;

import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.AtualizaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.BuscaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.BuscaHorarioFuncionamentoUsecase;
import com.br.second.tech.challenge.infra.controller.restaurante.request.DiaUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.DiaResponse;
import com.br.second.tech.challenge.infra.controller.restaurante.response.HorarioFuncionamentoResponse;
import com.br.second.tech.challenge.infra.presenter.DiaPresenter;
import com.br.second.tech.challenge.infra.presenter.HorarioFuncionamentoPresenter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante/{idRestaurante}/horario-funcionamento")
@Slf4j
public class HorarioFuncionamentoController {

    private final BuscaHorarioFuncionamentoUsecase buscaHorarioFuncionamentoUsecase;
    private final BuscaDiaFuncionamentoUsecase buscaDiaFuncionamentoUsecase;
    private final AtualizaDiaFuncionamentoUsecase atualizaDiaFuncionamentoUsecase;

    public HorarioFuncionamentoController(BuscaHorarioFuncionamentoUsecase buscaHorarioFuncionamentoUsecase, BuscaDiaFuncionamentoUsecase buscaDiaFuncionamentoUsecase, AtualizaDiaFuncionamentoUsecase atualizaDiaFuncionamentoUsecase) {
        this.buscaHorarioFuncionamentoUsecase = buscaHorarioFuncionamentoUsecase;
        this.buscaDiaFuncionamentoUsecase = buscaDiaFuncionamentoUsecase;
        this.atualizaDiaFuncionamentoUsecase = atualizaDiaFuncionamentoUsecase;
    }

    @GetMapping
    public HorarioFuncionamentoResponse obterHorarioFuncionamento(@PathVariable Long idRestaurante) {
        log.info("[HorarioFuncionamentoController] - Iniciando busca de horário de funcionamento do restaurante {}", idRestaurante);
        var horario = buscaHorarioFuncionamentoUsecase.executar(idRestaurante);
        log.info("[HorarioFuncionamentoController] - Horário de funcionamento do restaurante {} encontrado com sucesso", idRestaurante);
        return HorarioFuncionamentoPresenter.toResponse(horario);
    }

    @GetMapping("/{diaSemana}")
    public DiaResponse obterDiaFuncionamento(@PathVariable Long idRestaurante, @PathVariable Dias diaSemana) {
        log.info("[HorarioFuncionamentoController] - Iniciando busca do dia {} do horário de funcionamento do restaurante {}", diaSemana, idRestaurante);
        var diaResult = buscaDiaFuncionamentoUsecase.execute(idRestaurante, diaSemana);
        var diaResponse = DiaPresenter.toResponse(diaResult);
        log.info("[HorarioFuncionamentoController] - Dia {} do horário de funcionamento do restaurante {} encontrado com sucesso", diaSemana, idRestaurante);
        return diaResponse;
    }

    @PatchMapping("/{diaSemana}")
    public void atualizaDia(@PathVariable Long idRestaurante, @PathVariable Dias diaSemana, @RequestBody @Valid DiaUpdateRequest diaUpdateRequest){
        log.info("[HorarioFuncionamentoController] - Iniciando atualização horário de funcionamento do restaurante {}", idRestaurante);
        var diaDomain = DiaPresenter.toDomain(diaUpdateRequest, diaSemana);
        atualizaDiaFuncionamentoUsecase.executar(idRestaurante, diaDomain);
    }
}
