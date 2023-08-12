package com.proyecto.faan.service;

import com.proyecto.faan.model.Persona;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface PersonaService extends GenericService<Persona, Integer> {

    Page<Persona> findByCedulaOrApellido(@Param("filter") String filter, Pageable pageable);

}
