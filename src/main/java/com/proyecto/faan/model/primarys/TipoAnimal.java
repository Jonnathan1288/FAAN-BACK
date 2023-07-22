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
@Table(name = "tiposAnimales")
public class TipoAnimal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAnimal")
    private Integer idTipoAnimal;

    @Column(name = "nombreTipo", unique = true)
    private String nombreTipo;

    @Column(name = "descripcionAnimal")
    private String descripcionAnimal;

    @Column(name = "estadoTipo")
    private String estadoTipo;

    @JsonIgnore
    @OneToMany (mappedBy = "tipoAnimal")
    private List<RazaAnimal> razaAnimals;
}
