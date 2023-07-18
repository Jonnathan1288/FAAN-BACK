package com.proyecto.faan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnfermedad")
    private Integer idEnfermedad;

    @Column(name = "fechaEnfermedad")
    private LocalDate fechaEnfermedad;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estadoEnfermedad")
    private String estadoEnfermedad;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name="idTipoEnfermedad",referencedColumnName ="idTipoEnfermedad")
    private TipoEnfermedad tipoEnfermedad;

    @ManyToOne
    @JoinColumn(name="idFichaMedica",referencedColumnName ="idFichaMedica")
    private FichaMedica fichaMedica;
}
