package com.app.models;

import com.app.util.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre1;
    String nombre2;
    String apellido1;
    String apellido2;
    String email;
    Long telefono;
    String password;
    String username;
    @Enumerated(EnumType.STRING)
    TipoDocumento tipoDocumento;
    Long documento;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rols_id"))
    @JsonIgnore
    @ToString.Exclude
    Set<Rol> roles = new LinkedHashSet<>();

}
