package com.app.util;

import lombok.Getter;

@Getter
public enum TipoDocumento {
    CC("Cédula de ciudadanía"),
    CE("Cédula de extranjería"),
    TI("Tarjeta de identidad"),
    RC("Registro civil"),
    PA("Pasaporte");

    private final String descripcion;

    private TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }
}
