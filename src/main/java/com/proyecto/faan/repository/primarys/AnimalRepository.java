package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.payload.PeyloadAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
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


    public Page<Animal> findByNombreAnimalContainingIgnoreCaseOrPlacaAnimalContainingIgnoreCase(String nameA, String placaA, Pageable pageable);

    public Boolean existsByPlacaAnimal(String placa);


//    ====================================================================================
    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a INNER JOIN detalle_adopcion da ON da.id_animal = a.id_animal", nativeQuery = true)
    public Page<Animal> Adopciones(Pageable pageable);
    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a LEFT JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE da.id_animal IS NULL", nativeQuery = true)
    public Page<Animal> NoAdopciones(Pageable pageable);

    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a INNER JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE LOWER(a.nombre_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')) OR LOWER(a.placa_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%'))", nativeQuery = true)
    public Page<Animal> PlacaONombreAdopciones(@Param("nombreOrPlaca") String nombreOrPlaca, Pageable pageable);
    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a LEFT JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE da.id_animal IS NULL AND (LOWER(a.nombre_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')) OR LOWER(a.placa_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')))", nativeQuery = true)
    public Page<Animal> PlacaONombreNoAdopciones(@Param("nombreOrPlaca") String nombreOrPlaca, Pageable pageable);
//    ====================================================================================

}
