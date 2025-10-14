package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import com.br.second.tech.challenge.core.domain.Restaurante;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prato")
public class PratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean apenasNoLocal;
    private String fotoDoPrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataDeAtualizacao;

    public PratoEntity(String nome,
                       String descricao,
                       BigDecimal preco,
                       Boolean apenasNoLocal,
                       String fotoDoPrato,
                       RestauranteEntity restaurante,
                       LocalDateTime data) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.apenasNoLocal = apenasNoLocal;
        this.fotoDoPrato = fotoDoPrato;
        this.restaurante = restaurante;
        this.dataDeCriacao = data;
        this.dataDeAtualizacao = data;
    }
}
