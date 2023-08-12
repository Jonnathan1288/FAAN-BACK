package com.proyecto.faan.service;

import com.proyecto.faan.model.Persona;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.repository.PersonaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl  extends GenericServiceImpl<Persona, Integer> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public GenericRepository<Persona, Integer> getDao() {
        return personaRepository;
    }

    @Override
    public Page<Persona> findByCedulaOrApellido(String filter, Pageable pageable) {
        Page<Persona> findPersona = personaRepository.cedulaOrApellido(filter, pageable);

        if(findPersona != null){
            return findPersona;
        }
        return null;
    }
}
