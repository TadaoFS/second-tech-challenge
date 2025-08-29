package com.br.second.tech.challenge.app.entities;

public class TipoUsuario {

    private Long id;
    private String tipo;

    public TipoUsuario() {
    }

    public TipoUsuario(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }
}
