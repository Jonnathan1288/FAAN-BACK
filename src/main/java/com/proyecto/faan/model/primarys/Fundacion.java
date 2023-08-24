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

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "nombreFundacion")
    private String nombreFundacion;

    @Column(name = "eslogan")
    private String eslogan;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "paginaWeb")
    private String paginaWeb;

    @Column(name = "horarios")
    private String horarios;

    @Column(name = "acronimo")
    private String acronimo;

    @Column(name = "logoFundacion")
    private String logoFundacion;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "fundacion")
    private List<Animal> animals;

}
