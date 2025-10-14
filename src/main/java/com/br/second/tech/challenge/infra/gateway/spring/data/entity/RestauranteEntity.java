package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurante")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "horario_funcionamento_id", nullable = false)
    private HorarioFuncionamentoEntity horarioFuncionamento;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoEntity endereco;

    @OneToMany(
            mappedBy = "restaurante",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<PratoEntity> cardapio = new ArrayList<>();

    public RestauranteEntity(Long id) {
        this.id = id;
    }

    public RestauranteEntity(String nome,
                             String tipoCozinha,
                             HorarioFuncionamentoEntity horarioFuncionamento,
                             UsuarioEntity usuario,
                             EnderecoEntity endereco,
                             List<PratoEntity> cardaio,
                             LocalDateTime dataCriacao,
                             LocalDateTime dataAtualizacao) {
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.usuario = usuario;
        this.endereco = endereco;
        this.cardapio = cardaio;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
