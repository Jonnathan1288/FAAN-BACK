package com.proyecto.faan.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "username", unique = true)
    @NotBlank(message = "El campo noo debe estar vacio")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fotoPerfil")
    private String fotoPerfil;

    @Column(name = "estadoUsuario", columnDefinition = "BOOLEAN")
    private Boolean estadoUsuario;

    @Column(name = "tokenPassword", length = 1800)
    private String tokenPassword;

    // RELATIONS
    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;


    //RELATIONS THE MANY TO MANY

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol")
    )
    private List<Rol> roles;


    public Usuario(String username, String password, String fotoPerfil, Boolean estadoUsuario, Persona persona) {
        this.username = username;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.estadoUsuario = estadoUsuario;
        this.persona = persona;
    }

    public Usuario(String username, String password, String fotoPerfil, Boolean estadoUsuario,  Persona persona, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.estadoUsuario = estadoUsuario;
        this.persona = persona;
        this.roles = roles;
    }

    public Usuario(){}

}
