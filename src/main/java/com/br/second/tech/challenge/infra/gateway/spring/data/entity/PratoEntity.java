package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Double preco;
    private String urlFoto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
//    @ManyToOne
//    @JoinColumn(name = "cardapio_id", nullable = false)
//    private CardapioEntity cardapioEntity;
}
