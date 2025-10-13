package com.br.second.tech.challenge.core.usecase.usuario;

import com.br.second.tech.challenge.core.exception.AutorizacaoIncorreta;
import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.gateway.EncriptadorGateway;
import com.br.second.tech.challenge.core.gateway.UsuarioGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlteraSenhaUsuarioUsecase {

    private final UsuarioGateway usuarioGateway;
    private final EncriptadorGateway encriptadorGateway;

    public AlteraSenhaUsuarioUsecase(UsuarioGateway usuarioGateway, EncriptadorGateway encriptadorGateway) {
        this.usuarioGateway = usuarioGateway;
        this.encriptadorGateway = encriptadorGateway;
    }

    public void executar(String login, String senhaAntiga, String senhaNova){
        log.info("[AlteraSenhaUsuarioUsecase.executar]: Alterando senha do idDonoRestaurante: {}", login);
        var user = usuarioGateway.obterPorLogin(login);
        user.ifPresentOrElse( usuario ->  {
            if(encriptadorGateway.validarSenha(senhaAntiga, usuario.senha())){
                usuarioGateway.alterarSenha(usuario.id(), senhaNova);
                log.info("[AlteraSenhaUsuarioUsecase.executar] - Senha alterada com sucesso - login: {}", login);
            } else {
                log.error("[AlteraSenhaUsuarioUsecase.executar] - Senha antiga nao confere - login: {}", login);
                throw new AutorizacaoIncorreta("Falha na validacao do idDonoRestaurante");
            }
        }, () -> {
            log.error("[AlteraSenhaUsuarioUsecase.executar] - Usuario nao encontrado - id: {}", login);
            throw new UsuarioNotFound("Usuario {login} nao encontrado".replace("{login}", String.valueOf(login)));
        });
    }
}
