package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.ExamenFisico;
import com.proyecto.faan.payload.PeyloadExamenFisicoAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface ExamenFisicoService extends GenericService<ExamenFisico, Integer> {
    List<PeyloadExamenFisicoAnimal> buscarExamenFisicoPorIdFichaMedica(Integer idFichaMedica);
}
