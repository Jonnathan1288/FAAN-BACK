package com.proyecto.faan.service;

import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.repository.TratamientoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoServiceImpl extends GenericServiceImpl<Tratamiento, Integer> implements TratamientoService{
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public GenericRepository<Tratamiento, Integer> getDao() {
        return tratamientoRepository;
    }
}
