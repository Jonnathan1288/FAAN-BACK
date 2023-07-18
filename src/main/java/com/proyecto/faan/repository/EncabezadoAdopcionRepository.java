package com.proyecto.faan.repository;

import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.model.EncabezadoAdopcion;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncabezadoAdopcionRepository extends GenericRepository<EncabezadoAdopcion,Integer> {
}
