package com.br.second.tech.challenge.infra.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String login;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity enderecoEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private TipoUsuarioEntity tipoUsuario;
//    @OneToOne(cascade = CascadeType.ALL)
//    private RestauranteEntity restauranteEntity;

}
