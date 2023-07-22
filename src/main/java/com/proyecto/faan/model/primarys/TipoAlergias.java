/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author LaptopSA
 */
@Setter
@Getter
@Entity
@Table(name = "TipoAlergias")
public class TipoAlergias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAlergia")
    private Integer idTipoAlergia;

    @Column(name = "nombreAlergia")
    private String nombreAlergia;

    @Column(name = "estado")
    private Integer estado;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoAlergias")
    private List<Alergias> alergias;

}
