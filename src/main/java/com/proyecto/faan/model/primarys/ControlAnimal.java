package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "controlAnimales")
public class ControlAnimal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idControlAnimal")
    private Integer idControlAnimal;

    @Column(name = "fechaControlAnimal")
    private LocalDate fechaControlAnimal;

    @Column(name = "observaciones",length = 1500)
    private String observaciones;

    @Column(name = "estadoControl")
    private Boolean estadoControl;

    @Column(name = "nombreVeterinario", length = 70)
    private String nombreVeterinario;

    @Column(name = "pesoActual")
    private Double pesoActual;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "idAnimal", referencedColumnName = "idAnimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "idEstadoAnimal", referencedColumnName = "idEstadoAnimal")
    private EstadoAnimal estadoAnimal;

}
