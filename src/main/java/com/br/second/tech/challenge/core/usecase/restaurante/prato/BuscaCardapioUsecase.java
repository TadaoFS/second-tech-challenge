package com.br.second.tech.challenge.core.usecase.restaurante.prato;

import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.exception.RestauranteSemCardapioException;
import com.br.second.tech.challenge.core.gateway.PratoGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuscaCardapioUsecase {

    private final PratoGateway pratoGateway;

    public BuscaCardapioUsecase(PratoGateway pratoGateway) {
        this.pratoGateway = pratoGateway;
    }

    public List<Prato> executar(Long idRestaurante){
        log.info("[BuscaCArdapioUsecase] Buscando cardápio do restaurante com ID {}", idRestaurante);
        var cardapio = pratoGateway.obterCardapio(idRestaurante);
        log.info("[BuscaCArdapioUsecase] Cardápio do restaurante com ID {} obtido com sucesso", idRestaurante);
        if(cardapio.isEmpty()){
            log.error("[BuscaCArdapioUsecase] Restaurante com ID {} não possui cardápio", idRestaurante);
            throw new RestauranteSemCardapioException("Restaurante com ID {} não possui cardápio".replace("{}", idRestaurante.toString()));
        }
        return cardapio;
    }
}
