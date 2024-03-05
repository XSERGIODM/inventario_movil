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
    Long familia_id;
    String familia_nombre;
    Boolean familia_estado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "familia_marca_id")
    @JsonIgnore
    @ToString.Exclude
    private Marca familia_marca;

    @OneToMany(mappedBy = "modelo_familia", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Moodelo> modelos = new ArrayList<>();
}
