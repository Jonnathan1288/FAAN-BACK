package com.proyecto.faan.payload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadEnfermedadAnimal {
    @Column(name="fechaEnfermedad")
    LocalDate getfechaEnfermedad();

    @Column(name="observaciones")
    String getobservaciones();

    @Column(name="estadoEnfermedad")
    String getestadoEnfermedad();

    @Column(name="nombreEnfermedad")
    String getnombreEnfermedad();
}
