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

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;


    // REFERENCE
    
}
