package com.br.second.tech.challenge.infra.database.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DiaFuncionamento")
public class DiaFuncionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Dias dia;
    private Integer horarioAbertura;
    private Integer horarioFechamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restauranteEntity;
}
