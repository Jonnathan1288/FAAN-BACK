package com.proyecto.faan.repository;

import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadRepository extends GenericRepository<Enfermedad,Integer> {
}
