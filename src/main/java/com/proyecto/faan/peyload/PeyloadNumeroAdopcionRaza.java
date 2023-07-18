package com.proyecto.faan.peyload;

import jakarta.persistence.Column;

public interface PeyloadNumeroAdopcionRaza {
    @Column(name="nombreRaza")
    String getnombreRaza();

    @Column(name="numeroAdopcion")
    String getnumeroAdopcion();

}
