package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.core.enums.TipoUsuario;

import java.time.Clock;
import java.time.LocalDateTime;

public record Usuario(
        Long id,
        String nome,
        String email,
        String login,
        String senha,
        Endereco endereco,
        TipoUsuario tipoUsuario,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {

    public Usuario(Long id, String email, String nome, String login, Endereco domain, TipoUsuario tipoUsuario, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this(id, nome, email, login, "", domain, tipoUsuario, dataCriacao, dataAtualizacao);
    }

    public Usuario(String email, String nome, String login, String senha, Endereco domain) {
        this(null, nome, email, login, senha, domain, null, null, null);
    }

    public Usuario(Long idUsuario) {
        this(idUsuario, null, null, null, null, null, null, null, null);
    }

    public Usuario(Long id, String email, String nome, String login, Endereco domain) {
        this(id, nome, email, login, null, domain, null, null, null);
    }

    public Usuario alteraTipo(TipoUsuario tipoUsuario, Clock clock){
        return new Usuario(
                this.id,
                this.nome,
                this.email,
                this.login,
                this.senha,
                this.endereco,
                tipoUsuario,
                this.dataCriacao,
                LocalDateTime.now(clock));
    }

    public Usuario gerarCliente(String pass) {
        return new Usuario(
                null,
                this.nome,
                this.email,
                this.login,
                pass,
                this.endereco,
                TipoUsuario.CLIENTE,
                this.dataCriacao,
                this.dataAtualizacao
        );
    }
}
