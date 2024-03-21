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
@Entity(name = "familia")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long familiaId;
    String familiaNombre;
    Boolean familiaEstado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "familia_marca_id")
    @JsonIgnore
    @ToString.Exclude
    private Marca familiaMarca;

    @OneToMany(mappedBy = "modeloFamilia", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Moodelo> modelos = new ArrayList<>();
}
