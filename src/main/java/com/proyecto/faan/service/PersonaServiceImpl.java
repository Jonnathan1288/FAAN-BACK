package com.proyecto.faan.service;

import com.proyecto.faan.model.Persona;
import com.proyecto.faan.repository.PersonaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl  extends GenericServiceImpl<Persona, Integer> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public GenericRepository<Persona, Integer> getDao() {
        return personaRepository;
    }
}
