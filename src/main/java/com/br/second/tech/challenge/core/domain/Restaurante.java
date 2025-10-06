package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.infra.database.entity.CardapioEntity;
import com.br.second.tech.challenge.infra.database.entity.EnderecoEntity;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Restaurante {
    private Long id;
    private String nome;
    private String tipoCozinha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private SemanaFuncionamento semanaFuncionamento;
    private UsuarioEntity usuario;
    private List<CardapioEntity> cardapioEntities;
    private EnderecoEntity enderecoEntity;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
    public SemanaFuncionamento getSemanaFuncionamento() { return semanaFuncionamento; }
    public void setSemanaFuncionamento(SemanaFuncionamento semanaFuncionamento) { this.semanaFuncionamento = semanaFuncionamento; }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(String tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<CardapioEntity> getCardapioEntities() {
        return cardapioEntities;
    }

    public void setCardapioEntities(List<CardapioEntity> cardapioEntities) {
        this.cardapioEntities = cardapioEntities;
    }

    public EnderecoEntity getEnderecoEntity() {
        return enderecoEntity;
    }

    public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }
}
