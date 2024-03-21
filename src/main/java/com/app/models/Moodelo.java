package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "modelo")
public class Moodelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long modeloId;
    String modeloNombre;
    Boolean modeloEstado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modelo_familia_id")
    @JsonIgnore
    @ToString.Exclude
    Familia modeloFamilia;


}
