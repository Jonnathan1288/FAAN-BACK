package com.proyecto.faan.service;

import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.payload.PeyloadTratamientoAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface TratamientoService extends GenericService<Tratamiento, Integer> {
    List<PeyloadTratamientoAnimal> buscarTratamientoPorIdFichaMedica(Integer idFichaMedica);
}
