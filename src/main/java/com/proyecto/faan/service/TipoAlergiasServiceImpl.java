package com.proyecto.faan.service;

import com.proyecto.faan.model.SituacionIngreso;
import com.proyecto.faan.model.TipoAlergias;
import com.proyecto.faan.repository.TipoAlergiasRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoAlergiasServiceImpl extends GenericServiceImpl<TipoAlergias, Integer> implements TipoAlergiasService{
    @Autowired
    private TipoAlergiasRepository tipoAlergiasRepository;

    @Override
    public GenericRepository<TipoAlergias, Integer> getDao() {
        return tipoAlergiasRepository;
    }
}
