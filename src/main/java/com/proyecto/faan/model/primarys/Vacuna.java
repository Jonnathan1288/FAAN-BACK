package com.proyecto.faan.model.primarys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "vacunas")
public class Vacuna implements Serializable { //Verficado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVacuna")
    private Integer idVacuna;

    @Column(name = "fechaVacuna")
    private LocalDate fechaVacuna;

    @Column(name = "fechaProximaVacuna")
    private LocalDate fechaProximaVacuna;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estadoVacuna")
    private Boolean estadoVacuna;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name="idTipoVacuna",referencedColumnName ="idTipoVacuna")
    private TipoVacuna tipoVacuna;

    @ManyToOne
    @JoinColumn(name="idControlAnimal",referencedColumnName ="idControlAnimal")
    private ControlAnimal controlAnimal;

}
