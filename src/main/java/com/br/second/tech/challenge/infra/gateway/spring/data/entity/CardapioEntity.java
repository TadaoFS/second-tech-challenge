package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cardapio")
public class CardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String modalidade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PratoEntity> pratos;
//    @ManyToOne
//    @JoinColumn(name = "restaurante_id", nullable = false)
//    private RestauranteEntity restauranteEntity;
}
