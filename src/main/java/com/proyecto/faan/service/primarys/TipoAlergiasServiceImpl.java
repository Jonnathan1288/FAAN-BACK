package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.TipoAlergias;
import com.proyecto.faan.repository.primarys.TipoAlergiasRepository;
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
