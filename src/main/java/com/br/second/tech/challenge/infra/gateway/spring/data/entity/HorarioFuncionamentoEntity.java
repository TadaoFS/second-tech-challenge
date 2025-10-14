package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import com.br.second.tech.challenge.infra.gateway.spring.data.model.HorarioUnidadeModel;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "seg_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "seg_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "seg_fechamento"))
    })
    private HorarioUnidadeModel segunda;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "ter_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "ter_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "ter_fechamento"))
    })
    private HorarioUnidadeModel terca;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "qua_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "qua_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "qua_fechamento"))
    })
    private HorarioUnidadeModel quarta;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "qui_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "qui_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "qui_fechamento"))
    })
    private HorarioUnidadeModel quinta;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "sext_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "sext_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "sext_fechamento"))
    })
    private HorarioUnidadeModel sexta;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "sab_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "sab_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "sab_fechamento"))
    })
    private HorarioUnidadeModel sabado;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aberto", column = @Column(name = "dom_aberto")),
            @AttributeOverride(name = "horarioAbertura", column = @Column(name = "dom_abertura")),
            @AttributeOverride(name = "horarioFechamento", column = @Column(name = "dom_fechamento"))
    })
    private HorarioUnidadeModel domingo;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
