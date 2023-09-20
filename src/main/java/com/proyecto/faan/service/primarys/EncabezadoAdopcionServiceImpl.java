package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.EncabezadoAdopcion;
import com.proyecto.faan.payload.AdoptedAnimal;
import com.proyecto.faan.repository.primarys.EncabezadoAdopcionRepository;
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

    @Override
    public AdoptedAnimal findAdoptedAnimal(Integer idAnimal) {
        return encabezadoAdopcionRepository.findAdoptedAnimal(idAnimal);
    }
}