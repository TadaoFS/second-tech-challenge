package com.br.second.tech.challenge.infra.database.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DiaFuncionamento")
public class DiaFuncionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Dias dia;
    private Integer horarioAbertura; // Formato 24 horas, ex: 1300 para 13:00
    private Integer horarioFechamento; // Formato 24 horas, ex: 1300 para 13:00
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restauranteEntity;

    public DiaFuncionamentoEntity(Long id, Dias dia, Integer horarioAbertura, Integer horarioFechamento, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, RestauranteEntity restauranteEntity) {
        this.id = id;
        this.dia = dia;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.restauranteEntity = restauranteEntity;
    }

    public DiaFuncionamentoEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dias getDia() {
        return dia;
    }

    public void setDia(Dias dia) {
        this.dia = dia;
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

    public RestauranteEntity getRestauranteEntity() {
        return restauranteEntity;
    }

    public void setRestauranteEntity(RestauranteEntity restauranteEntity) {
        this.restauranteEntity = restauranteEntity;
    }
}
