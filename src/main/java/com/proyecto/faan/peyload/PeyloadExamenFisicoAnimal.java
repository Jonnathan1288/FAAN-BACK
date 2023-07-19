package com.proyecto.faan.peyload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public interface PeyloadExamenFisicoAnimal {

    @Column(name="fechaRevisionFisisca")
    LocalDate getfechaRevisionFisisca();

    @Column(name="peso")
    Double getpeso();

    @Column(name="frecuenciaCardiaca")
    Double getfrecuenciaCardiaca();

    @Column(name="mucosa")
    String getmucosa();

    @Column(name="ojosrojos")
    String getojosrojos();

    @Column(name="piel")
    String getpiel();

    @Column(name="sistemaUrinario")
    String getsistemaUrinario();

    @Column(name="sistemaDigestivo")
    String getsistemaDigestivo();

    @Column(name="abdomen")
    String getabdomen();
}
