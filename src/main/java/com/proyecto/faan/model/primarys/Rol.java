package com.proyecto.faan.model.primarys;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;

    @Column(name = "nombreRol", length = 30)
    private String nombreRol;

    @Column(name = "estadoRolActivo")
    private Boolean estadoRolActivo;

    // REFERENCE
   /* @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;*/


}
