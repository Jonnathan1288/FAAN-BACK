package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Persona;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends GenericRepository<Persona, Integer> {
}
