package com.br.second.tech.challenge.infra.controller.usuario;

import com.br.second.tech.challenge.core.exception.UsuarioNotFound;
import com.br.second.tech.challenge.core.usecase.usuario.AtualizaUsuarioUsecase;
import com.br.second.tech.challenge.core.usecase.usuario.BuscaUsuarioUsecase;
import com.br.second.tech.challenge.core.usecase.usuario.CriaUsuarioUsecase;
import com.br.second.tech.challenge.core.usecase.usuario.DeletaUsuarioUsecase;
import com.br.second.tech.challenge.infra.controller.usuario.request.AtualizaUsuarioRequest;
import com.br.second.tech.challenge.infra.controller.usuario.request.CriarUsuarioRequest;
import com.br.second.tech.challenge.infra.controller.usuario.response.UsuarioResponse;
import com.br.second.tech.challenge.infra.presenter.UsuarioPresenter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private final CriaUsuarioUsecase criaUsuarioUsecase;
    private final BuscaUsuarioUsecase buscaUsuarioUSecase;
    private final AtualizaUsuarioUsecase atualizaUsuarioUsecase;
    private final DeletaUsuarioUsecase deletaUsuarioUsecase;

    public UsuarioController(CriaUsuarioUsecase criaUsuarioUsecase, BuscaUsuarioUsecase buscaUsuarioUSecase, AtualizaUsuarioUsecase atualizaUsuarioUsecase, DeletaUsuarioUsecase deletaUsuarioUsecase) {
        this.criaUsuarioUsecase = criaUsuarioUsecase;
        this.buscaUsuarioUSecase = buscaUsuarioUSecase;
        this.atualizaUsuarioUsecase = atualizaUsuarioUsecase;
        this.deletaUsuarioUsecase = deletaUsuarioUsecase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criar(@RequestBody @Valid CriarUsuarioRequest usuarioReq) {
        log.info("[UsuarioController.criar] - Criando usuario: [ {}]", usuarioReq);
        var req = UsuarioPresenter.toDomain(usuarioReq);
        var result = criaUsuarioUsecase.executar(req);
        return UsuarioPresenter.toResponse(result);
    }

    @GetMapping("/{id}")
    public UsuarioResponse buscarPorId(@PathVariable Long id) {
        log.info("[UsuarioController.buscarPorId] - Buscando usuario por id: [ {}]", id);
        var result = buscaUsuarioUSecase.executar(id);
        return result.map(UsuarioPresenter::toResponse)
                .orElseThrow(() -> {
                    log.error("[UsuarioController.buscarPorId] - Usuário {} não encontrado", id);
                    return new UsuarioNotFound("Usuário {} não encontrado".replace("{}", id.toString()));
                });
    }

    @PutMapping
    public UsuarioResponse atualizar(@RequestBody @Valid AtualizaUsuarioRequest usuarioReq) {
        log.info("[UsuarioController.atualizar] - Atualizando usuario: [ {}]", usuarioReq);
        var req = UsuarioPresenter.toDomain(usuarioReq);
        var result = atualizaUsuarioUsecase.executar(req);
        log.info("[UsuarioController.atualizar] - Usuario {} atualizado com sucesso", usuarioReq.id());
        return UsuarioPresenter.toResponse(result);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        log.info("[UsuarioController.deletar] - Deletando usuario: [ {}]", id);
        deletaUsuarioUsecase.executar(id);
        log.info("[UsuarioController.deletar] - Usuario {} deletado com sucesso", id);
    }
}
