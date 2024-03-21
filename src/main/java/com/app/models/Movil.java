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
    Long movilId;

    String movilImei1;

    String movilImei2;

    Integer movilBateria;

    Integer movilGigas;

    Double movilPrecioPublico;

    Integer movilCalidad;

    String movilObservaciones;

    Boolean movilEstado;

    String movilImagen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movil_color_id")
    @ToString.Exclude
    Color movilColor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movil_modelo_id")
    @ToString.Exclude
    Moodelo movilModelo;

    @OneToMany(mappedBy = "contextoMovil", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    List<Contexto> contextos = new ArrayList<>();

}
