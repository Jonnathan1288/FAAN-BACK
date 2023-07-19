package com.proyecto.faan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "tiposVacunas")
public class TipoVacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoVacuna")
    private Integer idTipoVacuna;

    @Column(name = "nombreVacuna", unique = true)
    private String nombreVacuna;

    @Column(name = "estado")
    private Boolean estado;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "tipoVacuna")
    private List<Vacuna> vacunas;
}
