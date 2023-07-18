package com.proyecto.faan.repository;

import com.proyecto.faan.model.FichaMedica;
import com.proyecto.faan.model.FichaRegistro;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRegistroRepository extends GenericRepository<FichaRegistro,Integer> {
}
