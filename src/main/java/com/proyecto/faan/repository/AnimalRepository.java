package com.proyecto.faan.repository;

import com.proyecto.faan.model.Animal;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends GenericRepository<Animal,Integer> {
    @Query("SELECT ra.nombreRaza as nombreRaza, COUNT(da) as numeroAdopcion FROM DetalleAdopcion da JOIN da.animal a JOIN a.razaAnimal ra GROUP BY ra.nombreRaza")
    List<PeyloadNumeroAdopcionRaza> findByAnimalPeyload();

    @Query("SELECT YEAR(enca.fechaAdopcion) as fechaAdopcion, COUNT(da) as numeroAdopcionFecha FROM DetalleAdopcion da JOIN da.encabezadoAdopcion enca GROUP BY YEAR(enca.fechaAdopcion)")
    List<PeyloadNumeroAdopcionFecha> findByAnimalPeyloadFechaAdopcion();

    //id, nombre, placa, foto,

    @Query("SELECT a.idAnimal AS idAnimal, a.nombreAnimal AS nombreAnimal, a.placaAnimal AS placaAnimal, a.fotoAnimal AS fotoAnimal, f AS fichaMedica FROM Animal a INNER JOIN a.fichaMedica f WHERE LOWER(a.nombreAnimal) LIKE %:filter% OR LOWER(a.placaAnimal) LIKE %:filter%")
    public Page<PeyloadAnimal> findByPlacaOrNombre(@Param("filter") String filter, Pageable pageable);


    public Page<Animal> findByNombreAnimalContainingIgnoreCaseOrPlacaAnimalContainingIgnoreCase(String nameA, String placaA, Pageable pageable);

}
