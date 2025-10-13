package com.br.second.tech.challenge.core.enums;

import com.br.second.tech.challenge.core.exception.TipoUsuarioNotFound;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuario {
    ADMIN,
    CLIENTE,
    DONO_RESTAURANTE;

    public static TipoUsuario extract(String novoTipo) {
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if (tipo.name().equalsIgnoreCase(novoTipo)) {
                return tipo;
            }
        }
        throw new TipoUsuarioNotFound("Tipo {} nao existente".replace("{}", novoTipo));
    }
}
