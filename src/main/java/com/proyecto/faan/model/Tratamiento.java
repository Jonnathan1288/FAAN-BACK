package com.proyecto.faan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "tratamientos")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTratamiento")
    private Integer idTratamiento;

    @Column(name = "fechaTratamiento")
    private LocalDate fechaTratamiento;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estadoTratamiento")
    private String estadoTratamiento;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name="idTipoTratamiento",referencedColumnName ="idTipoTratamiento")
    private TipoTratamiento tipoTratamiento;

    @ManyToOne
    @JoinColumn(name="idFichaMedica",referencedColumnName ="idFichaMedica")
    private FichaMedica fichaMedica;
}
