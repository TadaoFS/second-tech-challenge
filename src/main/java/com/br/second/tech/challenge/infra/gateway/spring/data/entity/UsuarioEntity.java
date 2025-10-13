package com.br.second.tech.challenge.infra.gateway.spring.data.entity;

import com.br.second.tech.challenge.core.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public UsuarioEntity(Long id, String nome, String email, String login, String senha, TipoUsuario tipoUsuario, EnderecoEntity entity) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.endereco = entity;
    }
}
