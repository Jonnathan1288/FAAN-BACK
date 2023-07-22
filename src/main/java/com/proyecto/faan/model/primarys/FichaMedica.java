package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "fichasMedicas")
public class FichaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaMedica")
    private Integer idFichaMedica;

    @Column(name = "descripcionFichaMedica")
    private String descripcionFichaMedica;

    // REFERENCE
    
    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<Animal> animals;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<Vacuna> vacunas;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<Tratamiento> tratamientos;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<Enfermedad> enfermedads;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<ExamenFisico> examenFisicos;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMedica")
    private List<Alergias> alergias;
}
