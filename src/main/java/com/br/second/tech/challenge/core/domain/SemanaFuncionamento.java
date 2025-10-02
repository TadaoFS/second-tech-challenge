package com.br.second.tech.challenge.core.domain;


import java.time.LocalDateTime;


public class SemanaFuncionamento {
    private Long id;
    private Dia segunda;
    private Dia terca;
    private Dia quarta;
    private Dia quinta;
    private Dia sexta;
    private Dia sabado;
    private Dia domingo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dia getSegunda() {
        return segunda;
    }

    public void setSegunda(Dia segunda) {
        this.segunda = segunda;
    }

    public Dia getTerca() {
        return terca;
    }

    public void setTerca(Dia terca) {
        this.terca = terca;
    }

    public Dia getQuarta() {
        return quarta;
    }

    public void setQuarta(Dia quarta) {
        this.quarta = quarta;
    }

    public Dia getQuinta() {
        return quinta;
    }

    public void setQuinta(Dia quinta) {
        this.quinta = quinta;
    }

    public Dia getSexta() {
        return sexta;
    }

    public void setSexta(Dia sexta) {
        this.sexta = sexta;
    }

    public Dia getSabado() {
        return sabado;
    }

    public void setSabado(Dia sabado) {
        this.sabado = sabado;
    }

    public Dia getDomingo() {
        return domingo;
    }

    public void setDomingo(Dia domingo) {
        this.domingo = domingo;
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
}
