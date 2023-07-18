package com.proyecto.faan.repository;

import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.model.Vacuna;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends GenericRepository<Vacuna,Integer> {
}
