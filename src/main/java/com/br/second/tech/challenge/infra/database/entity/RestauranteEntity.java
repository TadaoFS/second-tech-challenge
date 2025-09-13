package com.br.second.tech.challenge.infra.database.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipoCozinha;

    private LocalDateTime dataCriacao;

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
}
