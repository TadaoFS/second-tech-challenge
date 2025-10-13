package com.br.second.tech.challenge.core.usecase.restaurante.horariosemana;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.core.exception.DiaNotFound;
import com.br.second.tech.challenge.core.exception.RestauranteNotFound;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuscaDiaFuncionamentoUsecase {

    private final RestauranteGateway restauranteGateway;

    public BuscaDiaFuncionamentoUsecase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Dia execute(Long idRestaurante, Dias dia) {
        log.info("[BuscaDiaFuncionamentoUsecase] Iniciando busca do dia {} para o restaurante ID: {}", dia, idRestaurante);
        var restauranteOpt = restauranteGateway.obterPorId(idRestaurante);
        if (restauranteOpt.isPresent()) {
            var restaurante = restauranteOpt.get();
            var diaResult = restaurante.horarioFuncionamento().obterDia(dia);
            log.info("[BuscaDiaFuncionamentoUsecase] Dia {} encontrado para o restaurante ID: {}", dia, idRestaurante);
            return diaResult;
        } else {
            log.error("[BuscaDiaFuncionamentoUsecase] Restaurante com ID {} não encontrado", idRestaurante);
            throw new RestauranteNotFound("Restaurante não encontrado");
        }
    }
}
