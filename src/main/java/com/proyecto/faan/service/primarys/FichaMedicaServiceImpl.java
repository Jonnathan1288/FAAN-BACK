package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.FichaMedica;
import com.proyecto.faan.repository.primarys.FichaMedicaRepository;
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