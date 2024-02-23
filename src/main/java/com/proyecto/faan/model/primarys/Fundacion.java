package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "fundaciones")
public class Fundacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFudacion")
    private Integer idFudacion;

    @Column(name = "ruc", length = 25)
    private String ruc;

    @Column(name = "nombreFundacion", length = 70)
    private String nombreFundacion;

    @Column(name = "eslogan", length = 50)
    private String eslogan;

    @Column(name = "objetivo", length = 2000)
    private String objetivo;

    @Column(name = "correo", length = 70)
    private String correo;

    @Column(name = "direccion", length = 70)
    private String direccion;

    @Column(name = "paginaWeb", length = 70)
    private String paginaWeb;

    @Column(name = "horarios", length = 70)
    private String horarios;

    @Column(name = "acronimo", length = 40)
    private String acronimo;

    @Column(name = "logoFundacion", length = 100)
    private String logoFundacion;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "fundacion")
    private List<Animal> animals;

}
