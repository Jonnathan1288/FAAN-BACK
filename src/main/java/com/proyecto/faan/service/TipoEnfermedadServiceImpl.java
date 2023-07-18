package com.proyecto.faan.service;

import com.proyecto.faan.model.TipoEnfermedad;
import com.proyecto.faan.repository.TipoEnfermedadRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TipoEnfermedadServiceImpl extends GenericServiceImpl<TipoEnfermedad, Integer> implements TipoEnfermedadService{
    @Autowired
    private TipoEnfermedadRepository tipoEnfermedadRepository;

    @Override
    public GenericRepository<TipoEnfermedad, Integer> getDao() {
        return tipoEnfermedadRepository;
    }
}
