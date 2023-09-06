package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.DetalleAdopcion;
import com.proyecto.faan.service.generic.GenericService;

public interface DetalleAdopcionService extends GenericService<DetalleAdopcion, Integer> {

    //    ====================================================================================
    DetalleAdopcion findByIdAnimal(Integer idAnimal);
    //    ====================================================================================

}
