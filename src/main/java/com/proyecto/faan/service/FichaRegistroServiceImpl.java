package com.proyecto.faan.service;

import com.proyecto.faan.model.FichaMedica;
import com.proyecto.faan.model.FichaRegistro;
import com.proyecto.faan.repository.FichaMedicaRepository;
import com.proyecto.faan.repository.FichaRegistroRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaRegistroServiceImpl extends GenericServiceImpl<FichaRegistro, Integer> implements FichaRegistroService{
    @Autowired
    private FichaRegistroRepository fichaRegistroRepository;

    @Override
    public GenericRepository<FichaRegistro, Integer> getDao() {
        return fichaRegistroRepository;
    }
}