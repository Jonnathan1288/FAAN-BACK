package com.proyecto.faan.service;

import com.proyecto.faan.model.Vacuna;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface VacunaService extends GenericService<Vacuna, Integer> {
    List<PeyloadVacunasAnimal> buscarVacunasPorIdFichaMedica(Integer idFichaMedica);
}
