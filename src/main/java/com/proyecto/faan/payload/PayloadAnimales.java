package com.proyecto.faan.payload;

import jakarta.persistence.Column;

public interface PayloadAnimales {

    @Column(name="nombreAnimal")
    String getnombreAnimal();

    @Column(name="placaAnimal")
    String getplacaAnimal();

    @Column(name="edad")
    Integer getedad();

    @Column(name="nombreRaza")
    String getnombreRaza();

    @Column(name="fotoAnimal")
    String getfotoAnimal();
}
