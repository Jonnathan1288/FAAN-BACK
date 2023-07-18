package com.proyecto.faan.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;

    @Column(name = "nombreRol")
    private String nombreRol;

    @Column(name = "estadoRolActivo")
    private Boolean estadoRolActivo;

    // REFERENCE
   /* @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;*/


}
