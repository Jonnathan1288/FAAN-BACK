package com.proyecto.faan.service;

import com.proyecto.faan.model.TipoTratamiento;
import com.proyecto.faan.repository.TipoTratamientoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTratamientoServiceImpl extends GenericServiceImpl<TipoTratamiento, Integer> implements TipoTratamientoService{
    @Autowired
    private TipoTratamientoRepository tipoTratamientoRepository;

    @Override
    public GenericRepository<TipoTratamiento, Integer> getDao() {
        return tipoTratamientoRepository;
    }
}
