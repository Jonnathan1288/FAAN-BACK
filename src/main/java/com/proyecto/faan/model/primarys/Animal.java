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
@Table(name = "animales")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnimal")
    private Integer idAnimal;

    @Column(name = "placaAnimal", unique = true)
    private String placaAnimal;

    @Column(name = "nombreAnimal", length = 255)
    private String nombreAnimal;

    @Column(name = "fotoAnimal")
    private String fotoAnimal;

    @Column(name = "edadAnimal")
    private Integer edadAnimal;

    @Column(name = "estatura")
    private Integer estatura;

    @Column(name = "esterilizado")
    private Boolean esterilizado;

    @Column(name = "estadoAnimal")
    private String estadoAnimal;


    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "idRazaAnimal", referencedColumnName = "idRazaAnimal")
    private RazaAnimal razaAnimal;

    @ManyToOne
    @JoinColumn(name = "idFichaRegistro", referencedColumnName = "idFichaRegistro")
    private FichaRegistro fichaRegistro;

    @ManyToOne
    @JoinColumn(name = "idFudacion", referencedColumnName = "idFudacion")
    private Fundacion fundacion;


    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "animal")
    private List<DetalleAdopcion> detalleAdopcion;
    
}
