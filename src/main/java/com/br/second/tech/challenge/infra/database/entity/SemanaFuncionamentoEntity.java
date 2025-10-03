package com.br.second.tech.challenge.infra.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "semanaFuncionamento")
public class SemanaFuncionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "segunda_id")
    private DiaEntity segunda;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "terca_id")
    private DiaEntity terca;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarta_id")
    private DiaEntity quarta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quinta_id")
    private DiaEntity quinta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sexta_id")
    private DiaEntity sexta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sabado_id")
    private DiaEntity sabado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domingo_id")
    private DiaEntity domingo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public SemanaFuncionamentoEntity() {
    }

    public SemanaFuncionamentoEntity(Long id, DiaEntity segunda, DiaEntity terca, DiaEntity quarta, DiaEntity quinta, DiaEntity sexta, DiaEntity sabado, DiaEntity domingo, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public DiaEntity buscaDiaEspecifico(String dia){
        String lowerDia = dia.trim().toLowerCase();

        if(lowerDia.contains("segunda")){
            return this.getSegunda();
        }else if(lowerDia.contains("terça") || lowerDia.contains("terca")){
            return this.getTerca();
        }else if(lowerDia.contains("quarta")){
            return this.getQuarta();
        }else if(lowerDia.contains("quinta")){
            return this.getQuinta();
        }else if(lowerDia.contains("sexta")){
            return this.getSexta();
        }else if(lowerDia.contains("sábado") || lowerDia.contains("sabado")){
            return this.getSabado();
        }else if(lowerDia.contains("domingo")){
            return this.getDomingo();
        }else{
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaEntity getSegunda() {
        return segunda;
    }

    public void setSegunda(DiaEntity segunda) {
        this.segunda = segunda;
    }

    public DiaEntity getTerca() {
        return terca;
    }

    public void setTerca(DiaEntity terca) {
        this.terca = terca;
    }

    public DiaEntity getQuarta() {
        return quarta;
    }

    public void setQuarta(DiaEntity quarta) {
        this.quarta = quarta;
    }

    public DiaEntity getQuinta() {
        return quinta;
    }

    public void setQuinta(DiaEntity quinta) {
        this.quinta = quinta;
    }

    public DiaEntity getSexta() {
        return sexta;
    }

    public void setSexta(DiaEntity sexta) {
        this.sexta = sexta;
    }

    public DiaEntity getSabado() {
        return sabado;
    }

    public void setSabado(DiaEntity sabado) {
        this.sabado = sabado;
    }

    public DiaEntity getDomingo() {
        return domingo;
    }

    public void setDomingo(DiaEntity domingo) {
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
