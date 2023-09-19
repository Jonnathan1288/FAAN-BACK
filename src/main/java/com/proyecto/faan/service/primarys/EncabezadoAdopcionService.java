package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.EncabezadoAdopcion;
import com.proyecto.faan.payload.AdoptedAnimal;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.data.repository.query.Param;

public interface EncabezadoAdopcionService extends GenericService<EncabezadoAdopcion, Integer> {
    public AdoptedAnimal findAdoptedAnimal(Integer idAnimal);
}
