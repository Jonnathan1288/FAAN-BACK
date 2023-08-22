package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.DetalleAdopcion;
import com.proyecto.faan.repository.primarys.DetalleAdopcionRepository;
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