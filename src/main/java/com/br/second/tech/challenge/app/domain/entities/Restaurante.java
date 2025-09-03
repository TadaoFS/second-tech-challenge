package com.br.second.tech.challenge.app.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Restaurante {

    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private List<DiaFuncionamento> diasFuncionamento;
    private Usuario usuario; // Dono do restaurante
    private List<Cardapio> cardapios;
    private Endereco endereco;

    public Restaurante(Long id, String nome, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, List<DiaFuncionamento> diasFuncionamento, Usuario usuario, List<Cardapio> cardapios, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.diasFuncionamento = diasFuncionamento;
        this.usuario = usuario;
        this.cardapios = cardapios;
        this.endereco = endereco;
    }

    public Restaurante() {
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<DiaFuncionamento> getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(List<DiaFuncionamento> diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
