package com.br.second.tech.challenge.core.usecase.restaurante.prato;

import com.br.second.tech.challenge.core.exception.PratoNotFoundException;
import com.br.second.tech.challenge.core.gateway.PratoGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RemovePratoUsecase {

    private final PratoGateway pratoGateway;

    public RemovePratoUsecase(PratoGateway pratoGateway) {
        this.pratoGateway = pratoGateway;
    }

    public void executar(Long idPrato){
        log.info("[RemovePratoUsecase] Removendo prato com id {}", idPrato);
        var prato = pratoGateway.obtemPorId(idPrato);
        if(prato.isPresent()){
            pratoGateway.deletaPrato(idPrato);
            log.info("[RemovePratoUsecase] Prato com id {} removido com sucesso", idPrato);
        }else {
            log.error("[RemovePratoUsecase] Prato id {} nao encontrado", idPrato);
            throw new PratoNotFoundException("Prato id {} nao encontrado".replace("{}", idPrato.toString()));
        }
    }
}
