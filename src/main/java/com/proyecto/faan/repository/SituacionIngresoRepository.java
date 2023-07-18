package com.proyecto.faan.repository;

import com.proyecto.faan.model.Rol;
import com.proyecto.faan.model.SituacionIngreso;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacionIngresoRepository extends GenericRepository<SituacionIngreso,Integer> {
}
