package com.proyecto.faan.repository;

import com.proyecto.faan.model.TipoEnfermedad;
import com.proyecto.faan.model.TipoTratamiento;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTratamientoRepository extends GenericRepository<TipoTratamiento,Integer> {
}
