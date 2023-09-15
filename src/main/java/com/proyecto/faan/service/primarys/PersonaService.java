package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Persona;
import com.proyecto.faan.payload.PersonFind;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface PersonaService extends GenericService<Persona, Integer> {

    //    ====================================================================================
    Page<Persona> findByCedulaOrApellido(@Param("filter") String filter, Pageable pageable);
    //    ====================================================================================

    Boolean existsByIdentificacion(String cedulaPersona);

    Boolean existsByCorreo(String correoPersona);

    public PersonFind findPersonabyIdentificacion(String identificacion);

}
