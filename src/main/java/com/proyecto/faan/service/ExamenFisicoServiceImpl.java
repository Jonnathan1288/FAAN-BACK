package com.proyecto.faan.service;

import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.repository.EnfermedadRepository;
import com.proyecto.faan.repository.ExamenFisicoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenFisicoServiceImpl extends GenericServiceImpl<ExamenFisico, Integer> implements ExamenFisicoService{
    @Autowired
    private ExamenFisicoRepository examenFisicoRepository;

    @Override
    public GenericRepository<ExamenFisico, Integer> getDao() {
        return examenFisicoRepository;
    }
}