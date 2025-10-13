package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurante")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

    @OneToOne(cascade = CascadeType.ALL)
    private HorarioFuncionamentoEntity horarioFuncionamento;

    @OneToOne(cascade = CascadeType.MERGE)
    private UsuarioEntity usuario;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<PratoEntity> cardapio;
}
