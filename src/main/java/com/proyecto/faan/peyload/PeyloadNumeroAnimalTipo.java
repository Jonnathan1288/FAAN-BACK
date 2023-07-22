package com.proyecto.faan.peyload;

import jakarta.persistence.Column;

public interface PeyloadNumeroAnimalTipo {
    @Column(name="nombreTipo")
    String getnombreTipo();

    @Column(name="numerotipo")
    String getnumerotipo();

}
