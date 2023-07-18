package com.proyecto.faan.repository;

import com.proyecto.faan.model.TipoVacuna;
import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends GenericRepository<Tratamiento,Integer> {
}
