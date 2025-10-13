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
@Table(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private Long numero;
    private String bairro;
    private String cidade;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public EnderecoEntity(Long id, String cep, String logradouro, Long numero, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void obtemDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarDataAtualizacao() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
