package com.proyecto.faan.service;

import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.model.FichaMedica;
import com.proyecto.faan.repository.ExamenFisicoRepository;
import com.proyecto.faan.repository.FichaMedicaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaMedicaServiceImpl extends GenericServiceImpl<FichaMedica, Integer> implements FichaMedicaService{
    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    @Override
    public GenericRepository<FichaMedica, Integer> getDao() {
        return fichaMedicaRepository;
    }
}