package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Persona;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends GenericRepository<Persona, Integer> {

    //    ====================================================================================
    @Query(value = "SELECT p.identificacion as identificacion1, p.* FROM personas p WHERE LOWER(p.identificacion) LIKE LOWER(CONCAT('%', :cedulaOrApellido , '%')) || LOWER(p.apellido1) LIKE LOWER(CONCAT('%', :cedulaOrApellido , '%'))", nativeQuery = true)
    Page<Persona> cedulaOrApellido(@Param("cedulaOrApellido") String cedulaOrApellido, Pageable pageable);
//    ====================================================================================

}
