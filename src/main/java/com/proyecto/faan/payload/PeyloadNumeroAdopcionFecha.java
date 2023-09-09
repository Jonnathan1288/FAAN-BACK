package com.proyecto.faan.payload;

import jakarta.persistence.Column;

public interface PeyloadNumeroAdopcionFecha {
    @Column(name="numeroAdopcionFecha")
    String getnumeroAdopcionFecha();

    @Column(name="fechaAdopcion")
    String getfechaAdopcion();
}
