package com.br.second.tech.challenge.core.usecase.restaurante.horariosemana;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.domain.HorarioUnidade;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AtualizaDiaFuncionamentoUsecase {

    private final RestauranteGateway restauranteGateway;
    private final RelogioGateway relogioGateway;

    public AtualizaDiaFuncionamentoUsecase(RestauranteGateway restauranteGateway, RelogioGateway relogioGateway) {
        this.restauranteGateway = restauranteGateway;
        this.relogioGateway = relogioGateway;
    }

    public void executar(Long idRestaurante, HorarioUnidade dia, Dias diaSemana) {
        log.info("[AtualizaDiaFuncionamentoUsecase] Iniciando atualização do dia {} para o restaurante ID: {}", diaSemana, idRestaurante);
        var restauranteOpt = restauranteGateway.obterPorId(idRestaurante);
        if (restauranteOpt.isPresent()) {
            var restaurante = restauranteOpt.get();
            var hAtualizacao = relogioGateway.registrarTempo();
            var horarioAtualizado = restaurante.horarioFuncionamento().atualizaDia(dia, hAtualizacao, diaSemana);
            restauranteGateway.atualizaHorarioFuncionamento(idRestaurante, horarioAtualizado);
            log.info("[AtualizaDiaFuncionamentoUsecase] Dia {} atualizado com sucesso para o restaurante ID: {}", diaSemana, idRestaurante);
        } else {
            log.error("[AtualizaDiaFuncionamentoUsecase] Restaurante com ID {} não encontrado", idRestaurante);
            throw new RuntimeException("Restaurante não encontrado");
        }
    }
}
