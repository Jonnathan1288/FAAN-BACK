package com.proyecto.faan.service;

import com.proyecto.faan.model.TipoAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface TipoAnimalService extends GenericService<TipoAnimal, Integer> {
    List<PeyloadNumeroAnimalTipo> countAnimalesByTipoAnimal();
}
