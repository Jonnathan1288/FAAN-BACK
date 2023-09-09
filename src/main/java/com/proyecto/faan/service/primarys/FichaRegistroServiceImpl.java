package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.FichaRegistro;
import com.proyecto.faan.repository.primarys.FichaRegistroRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaRegistroServiceImpl extends GenericServiceImpl<FichaRegistro, Integer> implements FichaRegistroService{
    @Autowired
    private FichaRegistroRepository fichaRegistroRepository;

    @Override
    public GenericRepository<FichaRegistro, Integer> getDao() {
        return fichaRegistroRepository;
    }
}