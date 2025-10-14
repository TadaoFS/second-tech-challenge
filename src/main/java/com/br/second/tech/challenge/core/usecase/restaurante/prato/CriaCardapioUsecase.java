package com.br.second.tech.challenge.core.usecase.restaurante.prato;


import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.exception.RestauranteNotFoundException;
import com.br.second.tech.challenge.core.gateway.PratoGateway;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CriaCardapioUsecase {

    private final RestauranteGateway restauranteGateway;
    private final RelogioGateway relogioGateway;
    private final PratoGateway pratoGateway;

    public CriaCardapioUsecase(RestauranteGateway restauranteGateway, RelogioGateway relogioGateway, PratoGateway pratoGateway) {
        this.restauranteGateway = restauranteGateway;
        this.relogioGateway = relogioGateway;
        this.pratoGateway = pratoGateway;
    }

    public List<Prato> executar(Long idRestaurante, List<Prato> pratos){
        log.info("[CriaCardapioUsecase] criando cardapio para o restaurante {}", idRestaurante);
        var restauranteOp = restauranteGateway.obterPorId(idRestaurante);
        if(restauranteOp.isPresent()){
            var instante = relogioGateway.registrarTempo();
            var pratosCompletos = pratos.stream().map(
                    prato -> prato.vinculaPrato(idRestaurante, instante)
            ).toList();
            return pratoGateway.salvarPratos(pratosCompletos);
        }
        log.error("[CriaCardapioUsecase] restaurante {} nao encontrado", idRestaurante);
        throw new RestauranteNotFoundException("Restaurante {} nao encontrado".replace("{}", idRestaurante.toString()));
    }
}
