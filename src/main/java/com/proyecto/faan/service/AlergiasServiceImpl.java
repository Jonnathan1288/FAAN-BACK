package com.proyecto.faan.service;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Fundacion;
import com.proyecto.faan.repository.AlergiasRepository;
import com.proyecto.faan.repository.FundacionRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlergiasServiceImpl extends GenericServiceImpl<Alergias, Integer> implements AlergiasService{
    @Autowired
    private AlergiasRepository alergiasRepository;

    @Override
    public GenericRepository<Alergias, Integer> getDao() {
        return alergiasRepository;
    }
}