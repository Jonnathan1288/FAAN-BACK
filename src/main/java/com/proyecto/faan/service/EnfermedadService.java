package com.proyecto.faan.service;

import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.payload.PeyloadEnfermedadAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface EnfermedadService extends GenericService<Enfermedad, Integer> {
    List<PeyloadEnfermedadAnimal> buscarEnfermedadPorIdFichaMedica(Integer idFichaMedica);
}
