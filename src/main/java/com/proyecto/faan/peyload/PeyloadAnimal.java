package com.proyecto.faan.peyload;

import com.proyecto.faan.model.FichaMedica;
import jakarta.persistence.Column;

public interface PeyloadAnimal {
    String getidAnimal();
    String getplacaAnimal();
    String getnombreAnimal();
    FichaMedica getfichaMedica();
}
