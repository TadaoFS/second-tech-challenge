package com.br.second.tech.challenge.core.usecase.restaurante;

import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.enums.TipoUsuario;
import com.br.second.tech.challenge.core.exception.RestauranteJaExistenteException;
import com.br.second.tech.challenge.core.exception.UsuarioSemPermissaoException;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
@Slf4j
public class CriarResturanteUsecase {

    private final UsuarioGateway usuarioGateway;
    private final RestauranteGateway restauranteGateway;
    private final RelogioGateway relogioGateway;

    public CriarResturanteUsecase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway, Clock clock, RelogioGateway relogioGateway) {
        this.usuarioGateway = usuarioGateway;
        this.restauranteGateway = restauranteGateway;
        this.relogioGateway = relogioGateway;
    }

    public Restaurante execute(Restaurante restaurante) {
        log.info("[CriarRestauranteUsecase] Iniciando criação do restaurante: {}", restaurante.nome());
        var usuarioOp = usuarioGateway.obterPorId(restaurante.usuario().id());
        var restauranteOp = restauranteGateway.obterPorDonoRestaurante(restaurante.usuario().id());

        if (usuarioOp.isPresent()) {
            var usuario = usuarioOp.get();
            if(!TipoUsuario.DONO_RESTAURANTE.equals(usuario.tipoUsuario())){
                log.error("[CriarRestauranteUsecase] Usuário com ID {} não possui permissão para criar restaurante", restaurante.usuario().id());
                throw new UsuarioSemPermissaoException("Usuário não possui permissão para criar restaurante");
            }
            if(restauranteOp.isPresent()){
                log.error("[CriarRestauranteUsecase] Usuário com ID {} já possui um restaurante", restaurante.usuario().id());
                throw new UsuarioSemPermissaoException("Usuário já possui um restaurante");
            }
            var verificaRestaurante = restauranteGateway.obterPorNome(restaurante.nome());
            if(verificaRestaurante.isPresent()){
                log.error("[CriarRestauranteUsecase] Restaurante com nome {} já existe", restaurante.nome());
                throw new RestauranteJaExistenteException("Restaurante com esse nome já existe");
            }
            var restauranteCompleto = restaurante.criar(relogioGateway.registrarTempo(), usuario);
            var restauranteCriado = restauranteGateway.criarRestaurante(restauranteCompleto);
            log.info("[CriarRestauranteUsecase] Restaurante criado com sucesso: {}", restauranteCriado);
            return restauranteCriado;
        } else {
            log.error("[CriarRestauranteUsecase] Usuário com ID {} não encontrado", restaurante.usuario().id());
            throw new UsuarioNotFound("Usuário não encontrado");
        }
    }
}
