package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.TipoAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAnimalRepository extends GenericRepository<TipoAnimal,Integer> {
}
