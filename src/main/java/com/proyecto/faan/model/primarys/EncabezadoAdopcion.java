package com.proyecto.faan.model.primarys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "EncabezadoAdopcion")
public class EncabezadoAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEncabezadoAdopcion")
    private Integer idEncabezadoAdopcion;

    @Column(name = "fechaAdopcion")
    private LocalDate fechaAdopcion;

    @Column(name = "observacion", length = 1500)
    private String observacion;

    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @JsonIgnore
    @OneToMany(mappedBy = "encabezadoAdopcion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DetalleAdopcion> listaDetalle;
}
