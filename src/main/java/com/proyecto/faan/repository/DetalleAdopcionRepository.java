package com.proyecto.faan.repository;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAdopcionRepository extends GenericRepository<DetalleAdopcion,Integer> {
}
