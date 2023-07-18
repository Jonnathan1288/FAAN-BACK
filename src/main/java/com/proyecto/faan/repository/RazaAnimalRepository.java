package com.proyecto.faan.repository;

import com.proyecto.faan.model.FichaRegistro;
import com.proyecto.faan.model.RazaAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaAnimalRepository extends GenericRepository<RazaAnimal,Integer> {
}
