package com.app.util;

import lombok.Getter;

@Getter
public enum TipoRol {
    ADMIN("Administrador"),
    USER("Usuario"),
    CLIENT("Cliente");

    private final String descripcion;

    private TipoRol(String descripcion) {
        this.descripcion = descripcion;
    }
}
