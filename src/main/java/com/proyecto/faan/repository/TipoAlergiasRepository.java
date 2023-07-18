package com.proyecto.faan.repository;

import com.proyecto.faan.model.SituacionIngreso;
import com.proyecto.faan.model.TipoAlergias;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlergiasRepository extends GenericRepository<TipoAlergias,Integer> {
}
