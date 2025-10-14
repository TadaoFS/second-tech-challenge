package com.br.second.tech.challenge.core.usecase.restaurante.prato;

import com.br.second.tech.challenge.core.domain.Prato;
import com.br.second.tech.challenge.core.exception.PratoNotFoundException;
import com.br.second.tech.challenge.core.gateway.PratoGateway;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EditaPratoUsecase {

    private final PratoGateway pratoGateway;
    private final RelogioGateway relogioGateway;

    public EditaPratoUsecase(PratoGateway pratoGateway, RelogioGateway relogioGateway) {
        this.pratoGateway = pratoGateway;
        this.relogioGateway = relogioGateway;
    }

    public void executar(Prato prato){
        log.info("[EditaPratoUsecase] Editando prato: {}", prato);
        var pratoOp = pratoGateway.obtemPorId(prato.id());
        if(pratoOp.isPresent()){
            var instante = relogioGateway.registrarTempo();
            var pratoAtualizado = prato.atualizarPrato(instante);
            pratoGateway.editaPrato(pratoAtualizado);
        }else {
            log.error("[EditaPratoUsecase] prato {} nao encontrado", prato.id());
            throw new PratoNotFoundException("Prato {} nao encontrado".replace("{}", prato.id().toString()));
        }
    }
}
