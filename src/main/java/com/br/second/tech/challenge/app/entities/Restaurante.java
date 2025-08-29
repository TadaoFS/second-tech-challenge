package com.br.second.tech.challenge.app.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Restaurante {

    private Long id;
    private String nome;
    private Integer horarioAbertura; // Formato 24 horas, ex: 1300 para 13:00
    private Integer horarioFechamento; // Formato 24 horas, ex: 1300 para 13:00
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Usuario usuario; // Dono do restaurante
    private List<Cardapio> cardapios;
    private Endereco endereco;

    public Restaurante() {
    }

    public Restaurante(Long id, String nome, Integer horarioAbertura, Integer horarioFechamento, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, Usuario usuario, List<Cardapio> cardapios, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
        this.cardapios = cardapios;
        this.endereco = endereco;
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

    public String gethorarioAbertura() {
        return this.horarioAbertura.toString().substring(0,2).concat(":").
                concat(this.horarioAbertura.toString().substring(0, 2));
    }

    public void sethorarioAbertura(Integer horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String gethorarioFechamento() {
        return this.horarioFechamento.toString().substring(0,2).concat(":").
                concat(this.horarioFechamento.toString().substring(0, 2));
    }

    public void sethorarioFechamento(Integer horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
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
