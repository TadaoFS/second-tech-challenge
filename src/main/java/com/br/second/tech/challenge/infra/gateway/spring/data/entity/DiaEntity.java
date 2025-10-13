package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import com.br.second.tech.challenge.core.enums.Dias;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dia")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Dias nome; // Ex: "SEGUNDA", "TERÇA", etc.
    private Boolean aberto; // Indica se o restaurante está aberto neste dia
    private String horarioAbertura; // Formato 24 horas, ex: 1300 para 13:00
    private String horarioFechamento; // Formato 24 horas, ex: 1300 para 13:00
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
