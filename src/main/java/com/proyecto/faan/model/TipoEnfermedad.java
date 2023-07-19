package com.proyecto.faan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "tiposEnfermedades")
public class TipoEnfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoEnfermedad")
    private Integer idTipoEnfermedad;

    @Column(name = "nombreEnfermedad", unique = true)
    private String nombreEnfermedad;

    @Column(name = "estado")
    private Boolean estado;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "tipoEnfermedad")
    private List<Enfermedad> enfermedad;
}
