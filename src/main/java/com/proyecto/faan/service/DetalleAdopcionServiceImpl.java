package com.proyecto.faan.service;

import com.proyecto.faan.model.Animal;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.repository.AnimalRepository;
import com.proyecto.faan.repository.DetalleAdopcionRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleAdopcionServiceImpl extends GenericServiceImpl<DetalleAdopcion, Integer> implements DetalleAdopcionService{
    @Autowired
    private DetalleAdopcionRepository detalleAdopcionRepository;

    @Override
    public GenericRepository<DetalleAdopcion, Integer> getDao() {
        return detalleAdopcionRepository;
    }
}