/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.faan.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LaptopSA
 */
@Setter
@Getter
@Entity
@Table(name = "ExamenFisico")
public class ExamenFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExamenFisico")
    private Integer idExamenFisico;

    @Column(name = "fechaRevisionFisisca")
    private LocalDate fechaRevisionFisisca;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "frecuenciaCardiaca")
    private Double frecuenciaCardiaca;

    @Column(name = "mucosa")
    private String mucosa;

    @Column(name = "ojosrojos")
    private String ojosrojos;

    @Column(name = "piel")
    private String piel;

    @Column(name = "sistemaUrinario")
    private String sistemaUrinario;

    @Column(name = "sistemaDigestivo")
    private String sistemaDigestivo;

    @Column(name = "abdomen")
    private String abdomen;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name="idFichaMedica",referencedColumnName ="idFichaMedica")
    private FichaMedica fichaMedica;

}
