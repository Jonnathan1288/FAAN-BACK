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
@Table(name = "situacionesIngreso")
public class SituacionIngreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSituacionIngreso")
    private Integer idSituacionIngreso;

    @Column(name = "nombreSituacionIngreso", length = 70)
    private String nombreSituacionIngreso;

    @Column(name = "estadoSituacionIngreso", length = 20)
    private String estadoSituacionIngreso;

    @JsonIgnore
    @OneToMany (mappedBy = "situacionIngreso")
    private List<FichaRegistro> fichaRegistros;
}
