package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.payload.*;
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

    @Query("SELECT a.idAnimal AS idAnimal, a.nombreAnimal AS nombreAnimal, a.placaAnimal AS placaAnimal, a.fotoAnimal AS fotoAnimal FROM Animal a WHERE (LOWER(a.nombreAnimal) LIKE CONCAT('%', COALESCE(:filter, ''), '%') OR LOWER(a.placaAnimal) LIKE CONCAT('%', COALESCE(:filter, ''), '%'))")
    public Page<PeyloadAnimal> findByPlacaOrNombre(@Param("filter") String filter, Pageable pageable);

    @Query("SELECT a.idAnimal AS idAnimal, a.nombreAnimal AS nombreAnimal, a.placaAnimal AS placaAnimal, a.fotoAnimal AS fotoAnimal FROM Animal a")
    public Page<PeyloadAnimal> findByAllPlacaOrNombre(Pageable pageable);
    public Page<Animal> findByNombreAnimalContainingIgnoreCaseOrPlacaAnimalContainingIgnoreCase(String nameA, String placaA, Pageable pageable);

    public Boolean existsByPlacaAnimal(String placa);

    //    ====================================================================================
    //    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a INNER JOIN detalle_adopcion da ON da.id_animal = a.id_animal", nativeQuery = true)
//    public Page<Animal> Adopciones(Pageable pageable);
//    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a LEFT JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE da.id_animal IS NULL", nativeQuery = true)
//    public Page<Animal> NoAdopciones(Pageable pageable);


    public Page<Animal> findByEstadoAnimal(String estadoAnimal, Pageable pageable);
    public Page<Animal> findByEstadoAnimalAndNombreAnimalContainingIgnoreCaseOrEstadoAnimalAndPlacaAnimalContainingIgnoreCase(String estadoAnimal1, String nombreAnimal, String estadoAnimal2, String placaAnimal, Pageable pageable);


//    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a INNER JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE LOWER(a.nombre_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')) OR LOWER(a.placa_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%'))", nativeQuery = true)
//    public Page<Animal> PlacaONombreAdopciones(@Param("nombreOrPlaca") String nombreOrPlaca, Pageable pageable);
//    @Query(value = "SELECT a.nombre_animal as nombreAnimal, a.* FROM animales a LEFT JOIN detalle_adopcion da ON da.id_animal = a.id_animal WHERE da.id_animal IS NULL AND (LOWER(a.nombre_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')) OR LOWER(a.placa_animal) LIKE LOWER(CONCAT('%', :nombreOrPlaca, '%')))", nativeQuery = true)
//    public Page<Animal> PlacaONombreNoAdopciones(@Param("nombreOrPlaca") String nombreOrPlaca, Pageable pageable);
//    ====================================================================================


    //MY QUERY
    @Query("SELECT a.idAnimal AS idAnimal, a.nombreAnimal AS nombreAnimal, a.placaAnimal AS placaAnimal, a.esterilizado as esterilizado,a.estadoAnimal as estadoAnimal, r.nombreRaza as nombreRaza FROM Animal a INNER JOIN a.razaAnimal r WHERE a.esterilizado = :esterilizado")
    public List<AnimalFilter> findByEsterilizadoAnimalFilterExport(@Param("esterilizado") Boolean esterilizado);

    @Query("SELECT a.idAnimal AS idAnimal, a.nombreAnimal AS nombreAnimal, a.placaAnimal AS placaAnimal, a.esterilizado AS esterilizado, a.estadoAnimal AS estadoAnimal, r.nombreRaza AS nombreRaza FROM Animal a INNER JOIN a.razaAnimal r WHERE (:esterilizado IS NULL OR a.esterilizado = :esterilizado) AND (:status IS NULL OR a.estadoAnimal = :status)")
    public List<AnimalFilter> findByMultipleAttributes(@Param("esterilizado") Boolean esterilizado, @Param("status") String status);

    @Query(value = "SELECT a.nombre_animal AS nombreAnimal, a.placa_animal AS placaAnimal, a.edad_animal AS edad, ra.nombre_raza AS nombreRaza, a.foto_animal AS fotoAnimal FROM animales a JOIN razas_animales ra ON a.id_raza_animal = ra.id_raza_animal WHERE a.estado_animal = 'F'", nativeQuery = true)
    public Page<PayloadAnimales> findAllAnimales(Pageable pageable);


}
