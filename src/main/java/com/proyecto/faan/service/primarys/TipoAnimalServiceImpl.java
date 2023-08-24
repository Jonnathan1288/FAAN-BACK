package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.TipoAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.repository.primarys.TipoAnimalRepository;
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
