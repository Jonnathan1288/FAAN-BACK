package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Rol;
import com.proyecto.faan.repository.primarys.RolRepository;
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
