package com.br.second.tech.challenge.infra.controller.restaurante;

import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.AtualizaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.BuscaDiaFuncionamentoUsecase;
import com.br.second.tech.challenge.core.usecase.restaurante.horariosemana.BuscaHorarioFuncionamentoUsecase;
import com.br.second.tech.challenge.infra.controller.restaurante.request.HorarioUnidadeUpdateRequest;
import com.br.second.tech.challenge.infra.controller.restaurante.response.HorarioFuncionamentoResponse;
import com.br.second.tech.challenge.infra.controller.restaurante.response.HorarioUnidadeResponse;
import com.br.second.tech.challenge.infra.presenter.HorarioFuncionamentoPresenter;
import com.br.second.tech.challenge.infra.presenter.HorarioUnidadePresenter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DONO_RESTAURANTE')")
    public HorarioUnidadeResponse obterDiaFuncionamento(@PathVariable Long idRestaurante, @PathVariable Dias diaSemana) {
        log.info("[HorarioFuncionamentoController] - Iniciando busca do dia {} do horário de funcionamento do restaurante {}", diaSemana, idRestaurante);
        var diaResult = buscaDiaFuncionamentoUsecase.execute(idRestaurante, diaSemana);
        var diaResponse = HorarioUnidadePresenter.toResponse(diaResult);
        log.info("[HorarioFuncionamentoController] - Dia {} do horário de funcionamento do restaurante {} encontrado com sucesso", diaSemana, idRestaurante);
        return diaResponse;
    }

    @PatchMapping("/{diaSemana}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DONO_RESTAURANTE')")
    public void atualizaDia(@PathVariable Long idRestaurante, @PathVariable Dias diaSemana, @RequestBody @Valid HorarioUnidadeUpdateRequest horarioUnidadeUpdateRequest){
        log.info("[HorarioFuncionamentoController] - Iniciando atualização horário de funcionamento do restaurante {}", idRestaurante);
        var diaDomain = HorarioUnidadePresenter.toDomain(horarioUnidadeUpdateRequest);
        atualizaDiaFuncionamentoUsecase.executar(idRestaurante, diaDomain, diaSemana);
    }
}
