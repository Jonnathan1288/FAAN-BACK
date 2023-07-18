package com.proyecto.faan.peyload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadVacunasAnimal {

    @Column(name="fechaVacuna")
    LocalDate getfechaVacuna();

    @Column(name="observaciones")
    String getobservaciones();

    @Column(name="estadoVacuna")
    String getestadoVacuna();

    @Column(name="nombreVacuna")
    String getnombreVacuna();
}
