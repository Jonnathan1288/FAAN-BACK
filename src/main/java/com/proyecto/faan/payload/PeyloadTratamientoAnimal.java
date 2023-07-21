package com.proyecto.faan.payload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadTratamientoAnimal {
    @Column(name="fechaTratamiento")
    LocalDate getfechaTratamiento();

    @Column(name="observaciones")
    String getobservaciones();

    @Column(name="estadoTratamiento")
    String getestadoTratamiento();

    @Column(name="nombreTratamiento")
    String getnombreTratamiento();
}
