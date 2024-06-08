package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "contexto")
public class Contexto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long contextoId;
    String contextoDetalle;
    String contextoDetalleSalida;
    Boolean contextoEstado;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime contextoFechaEntrada;
    LocalDateTime contextoFechaSalida;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contexto_movil_id")
    @JsonIgnore
    @ToString.Exclude
    Movil contextoMovil;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contexto_ubicacion_id")
    Ubicacion contextoUbicacion;

    public Integer diasTranscurridos() {
        return (LocalDateTime.now().getDayOfYear() - contextoFechaEntrada.getDayOfYear());
    }

}
