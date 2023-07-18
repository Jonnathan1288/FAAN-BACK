package com.proyecto.faan.repository;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Fundacion;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergiasRepository extends GenericRepository<Alergias,Integer> {
}
