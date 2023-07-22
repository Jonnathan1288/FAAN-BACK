package com.proyecto.faan.service;

import com.proyecto.faan.model.TipoAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.repository.TipoAlergiasRepository;
import com.proyecto.faan.repository.TipoAnimalRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAnimalServiceImpl extends GenericServiceImpl<TipoAnimal, Integer> implements TipoAnimalService{
    @Autowired
    private TipoAnimalRepository tipoAnimalRepository;

    @Override
    public GenericRepository<TipoAnimal, Integer> getDao() {
        return tipoAnimalRepository;
    }

    public List<PeyloadNumeroAnimalTipo> countAnimalesByTipoAnimal() {
        return tipoAnimalRepository.countAnimalesByTipoAnimal();
    }
}
