package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.TipoEnfermedad;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEnfermedadRepository extends GenericRepository<TipoEnfermedad,Integer> {
}
