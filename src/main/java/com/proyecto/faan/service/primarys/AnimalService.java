package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.payload.PeyloadAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalService extends GenericService<Animal, Integer> {
    List<PeyloadNumeroAdopcionRaza> findByAnimalPeyload();

    List<PeyloadNumeroAdopcionFecha> findByAnimalPeyloadFechaAdopcion();

    public Page<Animal> findByNombreAnimalOrPlacaAnimal(String filter, Pageable pageable);
    Page<PeyloadAnimal> findByPlacaOrNombre(@Param("filter") String filter, Pageable pageable);
    public Page<PeyloadAnimal> findByAllPlacaOrNombre(Pageable pageable);

    public Boolean existsByPlacaAnimal(String placa);

    //    ====================================================================================
    Page<Animal> AdoptadoOrNoAdoptado(@Param("adoptado") Boolean adoptado, @Param("nombreOrPlaca") String nombreOrPlaca, Pageable pageable);
    //    ====================================================================================

}
