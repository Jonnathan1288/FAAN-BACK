package com.proyecto.faan.payload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadControlPorAnimal {
    @Column(name="fechaControlAnimal")
    LocalDate getfechaControlAnimal();

    @Column(name="nombreVeterinario")
    String getnombreVeterinario();

    @Column(name="observaciones")
    String observaciones();

    @Column(name="pesoActual")
    String getpesoActual();

    @Column(name="tipoEstadoAnimal")
    String gettipoEstadoAnimal();
    @Column(name="descripcion")
    String getdescripcion();

}
