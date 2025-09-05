package com.br.second.tech.challenge.app.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipoCozinha;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiaFuncionamento> diasFuncionamento;

    @OneToOne
    @Column(nullable = false)
    private Usuario usuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cardapio> cardapios;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private Endereco endereco;

    public Restaurante(Long id, String nome, String tipoCozinha, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, List<DiaFuncionamento> diasFuncionamento, Usuario usuario, List<Cardapio> cardapios, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
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

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(String tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
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
