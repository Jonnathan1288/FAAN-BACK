package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.model.primarys.FichaRegistro;
import com.proyecto.faan.payload.PeyloadControlPorAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface ControlAnimalService extends GenericService<ControlAnimal, Integer> {

    List<PeyloadControlPorAnimal> AnimalesByControl(Integer idAnimal);
}
