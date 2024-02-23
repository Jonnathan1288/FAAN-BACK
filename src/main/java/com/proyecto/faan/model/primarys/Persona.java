package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Integer idPersona;

    @Column(name = "identificacion", unique = true)
    private String identificacion;

    @Column(name = "nombre1", length = 50)
    private String nombre1;

    @Column(name = "nombre2", length = 50)
    private String nombre2;

    @Column(name = "apellido1", length = 50)
    private String apellido1;

    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", length = 80)
    private String direccion;

    @Column(name = "correo", unique = true, length = 70)
    private String correo;

    @Column(name = "telefono", length = 12)
    private String telefono;

    @Column(name = "celular", length = 12)
    private String celular;

    @Column(name = "genero", length = 12)
    private String genero;

    // REFERENCE
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<EncabezadoAdopcion> encabezadoAdopcions;

    //Implement mapping fichaRegistro
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<FichaRegistro> fichaRegistros;


}
