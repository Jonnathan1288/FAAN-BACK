package com.proyecto.faan.service;

import com.proyecto.faan.model.Rol;
import com.proyecto.faan.model.SituacionIngreso;
import com.proyecto.faan.repository.SituacionIngresoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SituacionIngresoServiceImpl extends GenericServiceImpl<SituacionIngreso, Integer> implements SituacionIngresoService{
    @Autowired
    private SituacionIngresoRepository situacionIngresoRepository;

    @Override
    public GenericRepository<SituacionIngreso, Integer> getDao() {
        return situacionIngresoRepository;
    }
}
