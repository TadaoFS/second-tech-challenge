package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "horario_funcionamento")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioFuncionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "segunda_id")
    private DiaEntity segunda;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "terca_id")
    private DiaEntity terca;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarta_id")
    private DiaEntity quarta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quinta_id")
    private DiaEntity quinta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sexta_id")
    private DiaEntity sexta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sabado_id")
    private DiaEntity sabado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domingo_id")
    private DiaEntity domingo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
