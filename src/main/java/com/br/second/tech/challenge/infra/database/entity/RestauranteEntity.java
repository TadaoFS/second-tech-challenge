package com.br.second.tech.challenge.infra.database.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Restaurante")
public class RestauranteEntity {

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
    private List<DiaFuncionamentoEntity> diasFuncionamento;

    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioEntity usuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "restauranteEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CardapioEntity> cardapioEntities;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity enderecoEntity;

    public RestauranteEntity(Long id, String nome, String tipoCozinha, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, List<DiaFuncionamentoEntity> diasFuncionamento, UsuarioEntity usuario, List<CardapioEntity> cardapioEntities, EnderecoEntity enderecoEntity) {
        this.id = id;
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.diasFuncionamento = diasFuncionamento;
        this.usuario = usuario;
        this.cardapioEntities = cardapioEntities;
        this.enderecoEntity = enderecoEntity;
    }

    public RestauranteEntity() {
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

    public List<DiaFuncionamentoEntity> getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(List<DiaFuncionamentoEntity> diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
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
