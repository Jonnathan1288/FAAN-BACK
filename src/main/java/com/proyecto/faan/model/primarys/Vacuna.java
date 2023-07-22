package com.proyecto.faan.model.primarys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "vacunas")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVacuna")
    private Integer idVacuna;

    @Column(name = "fechaVacuna")
    private LocalDate fechaVacuna;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estadoVacuna")
    private String estadoVacuna;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name="idTipoVacuna",referencedColumnName ="idTipoVacuna")
    private TipoVacuna tipoVacuna;

    @ManyToOne
    @JoinColumn(name="idFichaMedica",referencedColumnName ="idFichaMedica")
    private FichaMedica fichaMedica;
}
