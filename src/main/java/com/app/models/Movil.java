package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movil")
public class Movil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movil_id;

    String movil_imei1;

    String movil_imei2;

    Integer movil_bateria;

    Integer movil_gigas;

    Double movil_precio_publico;

    Integer movil_calidad;

    String movil_observaciones;

    Boolean movil_estado;

    String movil_imagen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movil_color_id")
    @ToString.Exclude
    Color movil_color;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movil_modelo_id")
    @ToString.Exclude
    Moodelo movil_modelo;

    @OneToMany(mappedBy = "contexto_movil", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    List<Contexto> contextos = new ArrayList<>();

}
