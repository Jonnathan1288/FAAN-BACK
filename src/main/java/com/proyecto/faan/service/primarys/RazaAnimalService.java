package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface RazaAnimalService extends GenericService<RazaAnimal, Integer> {
    public List<RazaAnimal> findByEstadoRaza();
}
