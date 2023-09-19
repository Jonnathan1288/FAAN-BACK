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
@Table(name = "estadoAnimales")
public class EstadoAnimal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoAnimal")
    private Integer idEstadoAnimal;

    @Column(name = "tipoEstadoAnimal")
    private String tipoEstadoAnimal;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "estado", length = 30)
    private String estado;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "estadoAnimal")
    private List<ControlAnimal> controlAnimals;
    
}
