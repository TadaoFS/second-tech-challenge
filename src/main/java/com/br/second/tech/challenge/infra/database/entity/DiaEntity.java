package com.br.second.tech.challenge.infra.database.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dia")
public class DiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private Dias nome; // Ex: "SEGUNDA", "TERÇA", etc.
    private boolean aberto; // Indica se o restaurante está aberto neste dia
    private String horarioAbertura; // Formato 24 horas, ex: 1300 para 13:00
    private String horarioFechamento; // Formato 24 horas, ex: 1300 para 13:00
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public DiaEntity() {
    }

    public DiaEntity(Long id, Dias nome, boolean aberto, String horarioAbertura, String horarioFechamento, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.aberto = aberto;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

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
        return this.horarioAbertura.substring(0,2).concat(":").
                concat(this.horarioAbertura.substring(2, 4));
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return this.horarioFechamento.substring(0,2).concat(":").
                concat(this.horarioFechamento.substring(2, 4));
    }

    public void setHorarioFechamento(String horarioFechamento) {
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
