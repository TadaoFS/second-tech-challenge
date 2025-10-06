package com.br.second.tech.challenge.core.domain;

import com.br.second.tech.challenge.core.enums.Dias;

import java.time.LocalDateTime;

public class Dia {

    private Long id;
    private Dias nome; // Ex: "SEGUNDA", "TERÇA", etc.
    private boolean aberto; // Indica se o restaurante está aberto neste dia
    private String horarioAbertura; // Formato 24 horas, ex: 1300 para 13:00
    private String horarioFechamento; // Formato 24 horas, ex: 1300 para 13:00
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dias getNome() {
        return nome;
    }

    public void setNome(Dias nome) {
        this.nome = nome;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        if(horarioAbertura.contains("::")){
            horarioAbertura = horarioAbertura.replace("::", ":0");
        }
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        if(horarioFechamento.contains("::")){
            horarioFechamento = horarioFechamento.replace("::", ":0");
        }
        this.horarioFechamento = horarioFechamento;
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
