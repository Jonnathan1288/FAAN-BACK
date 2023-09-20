package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.EncabezadoAdopcion;
import com.proyecto.faan.payload.AdoptedAnimal;
import com.proyecto.faan.payload.AnimalFilter;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncabezadoAdopcionRepository extends GenericRepository<EncabezadoAdopcion,Integer> {

    @Query("SELECT " +
            "a.fotoAnimal as uriAnimal, " +
            "a.nombreAnimal as nombreA, " +
            "a.placaAnimal as placa, " +
            "da.documento as uriDocument, " +
            "da.observacion as observacionDetail, " +
            "e.observacion as observacionEnca, " +
            "e.fechaAdopcion as fechaAdopcion, " +
            "e.persona.identificacion as identificacion, " +
            "e.persona.nombre1 as nombre1, " +
            "e.persona.apellido1 as apellido1, " +
            "e.persona.correo as correo, " +
            "a.razaAnimal.nombreRaza as nombreRaza, " +
            "a.razaAnimal.tipoAnimal.nombreTipo as nombreTipo " +
            "FROM Animal a " +
            "INNER JOIN a.detalleAdopcion da " +
            "INNER JOIN da.encabezadoAdopcion e " +
            "WHERE a.idAnimal = :idAnimal")
    public AdoptedAnimal findAdoptedAnimal(@Param("idAnimal") Integer idAnimal);

}
