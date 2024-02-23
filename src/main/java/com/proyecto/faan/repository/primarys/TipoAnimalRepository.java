package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.TipoAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoAnimalRepository extends GenericRepository<TipoAnimal,Integer> {
    @Query("SELECT t.nombreTipo as nombreTipo, COUNT(a) as numerotipo FROM TipoAnimal t JOIN t.razaAnimals r JOIN r.animals a GROUP BY t.idTipoAnimal, t.nombreTipo")
    List<PeyloadNumeroAnimalTipo> countAnimalesByTipoAnimal();

    public List<TipoAnimal> findByEstadoTipo(@Param("status") String status);
}
