package com.proyecto.faan.payload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadAlergiasAnimal {
    @Column(name="fechaAlergias")
    LocalDate getfechaAlergias();

    @Column(name="observaciones")
    String getobservaciones();

    @Column(name="estado")
    String getestado();

    @Column(name="nombreAlergias")
    String getnombreAlergias();
}
