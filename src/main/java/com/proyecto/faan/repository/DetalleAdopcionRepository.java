package com.proyecto.faan.repository;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Animal;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleAdopcionRepository extends GenericRepository<DetalleAdopcion,Integer> {

    DetalleAdopcion findByAnimalIdAnimal(Integer idAnimal);


}
