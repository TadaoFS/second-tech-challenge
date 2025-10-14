package com.br.second.tech.challenge.infra.gateway.spring.data.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioUnidadeModel {
    private Boolean aberto;
    private String horarioAbertura;
    private String horarioFechamento;
}
