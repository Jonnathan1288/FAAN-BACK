package com.proyecto.faan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "tiposTratamientos")
public class TipoTratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoTratamiento")
    private Integer idTipoTratamiento;

    @Column(name = "nombreTratamiento", unique = true)
    private String nombreTratamiento;

    @Column(name = "estado")
    private Boolean estado;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "tipoTratamiento")
    private List<Tratamiento> tratamientos;
}
