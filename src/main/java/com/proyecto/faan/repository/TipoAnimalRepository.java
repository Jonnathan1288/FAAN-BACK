package com.proyecto.faan.repository;

import com.proyecto.faan.model.TipoAlergias;
import com.proyecto.faan.model.TipoAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoAnimalRepository extends GenericRepository<TipoAnimal,Integer> {
    @Query("SELECT t.nombreTipo as nombreTipo, COUNT(a) as numerotipo FROM TipoAnimal t JOIN t.razaAnimals r JOIN r.animals a GROUP BY t.idTipoAnimal, t.nombreTipo")
    List<PeyloadNumeroAnimalTipo> countAnimalesByTipoAnimal();
}
