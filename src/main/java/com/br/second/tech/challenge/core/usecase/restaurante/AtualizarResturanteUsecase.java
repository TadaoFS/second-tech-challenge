package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.enums.TipoUsuario;
import com.br.second.tech.challenge.core.exception.RestauranteJaExistenteException;
import com.br.second.tech.challenge.core.exception.RestauranteNotFound;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.exception.UsuarioSemPermissaoException;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AtualizarResturanteUsecase {

    private final RestauranteGateway restauranteGateway;
    private final UsuarioGateway usuarioGateway;
    private final RelogioGateway relogioGateway;

    public AtualizarResturanteUsecase(RestauranteGateway restauranteGateway, UsuarioGateway usuarioGateway, RelogioGateway relogioGateway) {
        this.restauranteGateway = restauranteGateway;
        this.usuarioGateway = usuarioGateway;
        this.relogioGateway = relogioGateway;
    }

    public Restaurante execute(Restaurante restaurante) {
        log.info("[AtualizarResturanteUsecase] Iniciando atualização do restaurante: {}", restaurante.nome());
        var original = restauranteGateway.obterPorId(restaurante.id());
        var restauranteOp = restauranteGateway.obterPorNome(restaurante.nome());
        var restauranteDonoOp = restauranteGateway.obterPorDonoRestaurante(restaurante.usuario().id());
        var usuarioOp = usuarioGateway.obterPorId(restaurante.usuario().id());

        if(usuarioOp.isEmpty()){
            log.error("[AtualizarResturanteUsecase] Usuário com ID {} não encontrado", restaurante.usuario().id());
            throw new UsuarioNotFound("Usuário do restaurante não encontrado");
        } else {
            if(!usuarioOp.get().tipoUsuario().equals(TipoUsuario.DONO_RESTAURANTE)){
                log.error("[AtualizarResturanteUsecase] Usuário com ID {} não tem permissão para ser dono de restaurante", restaurante.usuario().id());
                throw new UsuarioSemPermissaoException("Usuário do restaurante não encontrado");
            }
            if(restauranteDonoOp.isPresent() && !Objects.equals(restauranteDonoOp.get().id(), restaurante.id())){
                log.error("[AtualizarResturanteUsecase] Usuário com ID {} já é dono um restaurante", restaurante.usuario().id());
                throw new UsuarioSemPermissaoException("Usuário já é dono de um restaurante");
            }
        }

        if(original.isPresent()){
            if(restauranteOp.isPresent() && !restauranteOp.get().nome().equals(original.get().nome())){
                log.error("[AtualizarResturanteUsecase] Restaurante com nome {} já existe", restaurante.nome());
                throw new RestauranteJaExistenteException("Restaurante com esse nome já existe");
            }
            var restauranteAtualizado = restauranteGateway.atualizaRestaurante(restaurante.atualiza(usuarioOp.get(), relogioGateway.registrarTempo()));
            log.info("[AtualizarResturanteUsecase] Restaurante atualizado com sucesso: {}", restauranteAtualizado);
            return restauranteAtualizado;
        } else {
            log.error("[AtualizarResturanteUsecase] Restaurante com ID {} não encontrado", restaurante.id());
            throw new RestauranteNotFound("Restaurante não encontrado");
        }
    }
}
