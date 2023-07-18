package com.proyecto.faan.service;

import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.model.EncabezadoAdopcion;
import com.proyecto.faan.repository.DetalleAdopcionRepository;
import com.proyecto.faan.repository.EncabezadoAdopcionRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncabezadoAdopcionServiceImpl extends GenericServiceImpl<EncabezadoAdopcion, Integer> implements EncabezadoAdopcionService{
    @Autowired
    private EncabezadoAdopcionRepository encabezadoAdopcionRepository;

    @Override
    public GenericRepository<EncabezadoAdopcion, Integer> getDao() {
        return encabezadoAdopcionRepository;
    }
}