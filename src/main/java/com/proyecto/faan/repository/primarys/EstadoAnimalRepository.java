package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.model.primarys.EstadoAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAnimalRepository extends GenericRepository<EstadoAnimal,Integer> {


}
