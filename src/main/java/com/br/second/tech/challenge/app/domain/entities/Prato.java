package com.br.second.tech.challenge.app.domain.entities;

import java.time.LocalDateTime;

public class Prato {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String urlFoto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Prato(Long id, String nome, String descricao, Double preco, String urlFoto, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.urlFoto = urlFoto;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Prato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String geturlFoto() {
        return urlFoto;
    }

    public void seturlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public LocalDateTime getdataCriacao() {
        return dataCriacao;
    }

    public void setdataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getdataAtualizacao() {
        return dataAtualizacao;
    }

    public void setdataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}
