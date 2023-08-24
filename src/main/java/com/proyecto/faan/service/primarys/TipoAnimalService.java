package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.TipoAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface TipoAnimalService extends GenericService<TipoAnimal, Integer> {
    List<PeyloadNumeroAnimalTipo> countAnimalesByTipoAnimal();
}
