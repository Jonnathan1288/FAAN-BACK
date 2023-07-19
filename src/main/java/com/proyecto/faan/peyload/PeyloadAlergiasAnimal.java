package com.proyecto.faan.peyload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadAlergiasAnimal {
    @Column(name="fechaAlergias")
    LocalDate getfechaAlergias();

    @Column(name="observaciones")
    String getobservaciones();

    @Column(name="estadoAlergias")
    String getestadoAlergias();

    @Column(name="nombreAlergias")
    String getnombreAlergias();
}
