package com.proyecto.faan.service;

import com.proyecto.faan.model.TipoVacuna;
import com.proyecto.faan.repository.TipoVacunaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoVacunaServiceImpl extends GenericServiceImpl<TipoVacuna, Integer> implements TipoVacunaService{
    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    @Override
    public GenericRepository<TipoVacuna, Integer> getDao() {
        return tipoVacunaRepository;
    }
}
