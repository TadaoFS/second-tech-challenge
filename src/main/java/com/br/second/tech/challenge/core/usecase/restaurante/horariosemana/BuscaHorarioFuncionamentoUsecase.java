package com.br.second.tech.challenge.core.usecase.restaurante.horariosemana;

import com.br.second.tech.challenge.core.domain.HorarioFuncionamento;
import com.br.second.tech.challenge.core.exception.HorarioFuncionamentoNotFoundException;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuscaHorarioFuncionamentoUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscaHorarioFuncionamentoUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public HorarioFuncionamento executar(Long idRestaurante) {
        log.info("[BuscaHorarioFuncionamentoUsecase] Iniciando busca de horário de funcionamento para o restaurante ID: {}", idRestaurante);
        var horarioOpt = restauranteGateway.obterPorId(idRestaurante);
        if (horarioOpt.isPresent()) {
            log.info("[BuscaHorarioFuncionamentoUsecase] Horário de funcionamento encontrado para o restaurante ID: {}", idRestaurante);
            return horarioOpt.get().horarioFuncionamento();
        } else {
            log.error("[BuscaHorarioFuncionamentoUsecase] Nenhum horário de funcionamento encontrado para o restaurante ID: {}", idRestaurante);
            throw new HorarioFuncionamentoNotFoundException("Horário de funcionamento não encontrado para o restaurante ID: " + idRestaurante);
        }
    }
}
