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
@Table(name = "razasAnimales")
public class RazaAnimal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRazaAnimal")
    private Integer idRazaAnimal;

    @Column(name = "nombreRaza", unique = true)
    private String nombreRaza;

    @Column(name = "estadoRaza")
    private String estadoRaza;

    @ManyToOne
    @JoinColumn(name="idTipoAnimal",referencedColumnName ="idTipoAnimal")
    private TipoAnimal tipoAnimal;

    @JsonIgnore
    @OneToMany (mappedBy = "razaAnimal")
    private List<Animal> animals;
}
