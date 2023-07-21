package com.proyecto.faan.service;

import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.payload.PeyloadExamenFisicoAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface ExamenFisicoService extends GenericService<ExamenFisico, Integer> {
    List<PeyloadExamenFisicoAnimal> buscarExamenFisicoPorIdFichaMedica(Integer idFichaMedica);
}
