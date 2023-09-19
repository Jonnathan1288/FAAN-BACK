package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.EncabezadoAdopcion;
import com.proyecto.faan.model.primarys.EstadoAnimal;
import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.repository.primarys.EncabezadoAdopcionRepository;
import com.proyecto.faan.repository.primarys.EstadoAnimalRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoAnimalServiceImpl extends GenericServiceImpl<EstadoAnimal, Integer> implements EstadoAnimalService{
    @Autowired
    private EstadoAnimalRepository estadoAnimalRepository;

    @Override
    public GenericRepository<EstadoAnimal, Integer> getDao() {
        return estadoAnimalRepository;
    }

}