package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.model.primarys.DetalleAdopcion;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.repository.primarys.ControlAnimalRepository;
import com.proyecto.faan.repository.primarys.DetalleAdopcionRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlAnimalServiceImpl extends GenericServiceImpl<ControlAnimal, Integer> implements ControlAnimalService{
    @Autowired
    private ControlAnimalRepository controlAnimalRepository;

    @Override
    public GenericRepository<ControlAnimal, Integer> getDao() {
        return controlAnimalRepository;
    }
}