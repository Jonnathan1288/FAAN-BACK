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
@Table(name = "fichasRegistro")
public class FichaRegistro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaRegistro")
    private Integer idFichaRegistro;

    @Column(name = "descripcionFichaRegistro")
    private String descripcionFichaRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaRegistro")
    private List<Animal> animals;

    @ManyToOne
    @JoinColumn(name="idSituacionIngreso",referencedColumnName ="idSituacionIngreso")
    private SituacionIngreso situacionIngreso;

    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;
}
