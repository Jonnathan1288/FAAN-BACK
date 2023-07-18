package com.proyecto.faan.service;

import com.proyecto.faan.model.Fundacion;
import com.proyecto.faan.model.Rol;
import com.proyecto.faan.repository.FundacionRepository;
import com.proyecto.faan.repository.RolRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Integer> implements RolService{
    @Autowired
    private RolRepository rolRepository;

    @Override
    public GenericRepository<Rol, Integer> getDao() {
        return rolRepository;
    }
}
