package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.FichaMedica;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaMedicaRepository extends GenericRepository<FichaMedica,Integer> {
}
