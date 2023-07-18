package com.proyecto.faan.repository;

import com.proyecto.faan.model.TipoAlergias;
import com.proyecto.faan.model.TipoAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAnimalRepository extends GenericRepository<TipoAnimal,Integer> {
}
