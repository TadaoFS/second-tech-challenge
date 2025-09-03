package com.br.second.tech.challenge.app.domain.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

public class Cardapio {

    private Long id;
    private String nome;
    private String descricao;
    private String modalidade; // Presencial ou Delivery
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private List<Prato> pratos;
    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    public Cardapio() {
    }

    public Cardapio(Long id, String nome, String descricao, String modalidade, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, List<Prato> pratos, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.modalidade = modalidade;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.pratos = pratos;
        this.restaurante = restaurante;
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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
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

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
