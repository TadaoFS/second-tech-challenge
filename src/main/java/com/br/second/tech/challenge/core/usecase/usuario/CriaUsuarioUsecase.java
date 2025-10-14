package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.domain.Usuario;
import com.br.second.tech.challenge.core.exception.UsuarioExistenteException;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
@Slf4j
public class CriaUsuarioUsecase {

    private final EncriptadorGateway encriptadorGateway;
    private final UsuarioGateway usuarioGateway;
    private final RelogioGateway relogioGateway;

    public CriaUsuarioUsecase(EncriptadorGateway encriptadorGateway, UsuarioGateway usuarioGateway, Clock clock, RelogioGateway relogioGateway) {
        this.encriptadorGateway = encriptadorGateway;
        this.usuarioGateway = usuarioGateway;
        this.relogioGateway = relogioGateway;
    }

    public Usuario executar(Usuario usuario) {
        log.info("[CriaUsuarioUsecase.executar] - Criando idDonoRestaurante {}", usuario);
        var usuarioOp = usuarioGateway.obterPorLoginOuEmail(usuario.login(), usuario.email());
        if(usuarioOp.isPresent()){
            log.error("[CriaUsuarioUsecase.executar] - Usuario já existe. {}", usuario);
            throw new UsuarioExistenteException("Usuário com login ou email já existe.");
        }
        var pass = encriptadorGateway.encriptar(usuario.senha());
        var usuarioCompleto = usuario.gerarCliente(pass, relogioGateway.registrarTempo());
        var result = usuarioGateway.salvaUsuario(usuarioCompleto);
        log.info("[CriaUsuarioUsecase.executar] - Usuario criado com sucesso: {}", result.id());
        return result;
    }
}
