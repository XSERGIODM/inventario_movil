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
    Long contexto_id;
    String contexto_detalle;
    String contexto_detalle_salida;
    Boolean contexto_estado;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime contexto_fecha_entrada;
    LocalDateTime contexto_fecha_salida;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contexto_movil_id")
    @JsonIgnore
    @ToString.Exclude
    Movil contexto_movil;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contexto_ubicacion_id")
    Ubicacion contexto_ubicacion;

}
