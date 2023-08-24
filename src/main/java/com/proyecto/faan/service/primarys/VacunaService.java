package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Vacuna;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface VacunaService extends GenericService<Vacuna, Integer> {
    List<PeyloadVacunasAnimal> AnimalesByVacuna(Integer idControlAnimal);
}
