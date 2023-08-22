package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.SituacionIngreso;
import com.proyecto.faan.repository.primarys.SituacionIngresoRepository;
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
