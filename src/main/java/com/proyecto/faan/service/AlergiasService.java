package com.proyecto.faan.service;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Fundacion;
import com.proyecto.faan.peyload.PeyloadAlergiasAnimal;
import com.proyecto.faan.service.generic.GenericService;

import java.util.List;

public interface AlergiasService extends GenericService<Alergias, Integer> {
    List<PeyloadAlergiasAnimal> buscarAlergiasPorIdFichaMedica(Integer idFichaMedica);
}
