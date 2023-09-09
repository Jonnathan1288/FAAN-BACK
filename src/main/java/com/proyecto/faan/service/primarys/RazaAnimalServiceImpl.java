package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.repository.primarys.RazaAnimalRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaAnimalServiceImpl extends GenericServiceImpl<RazaAnimal, Integer> implements RazaAnimalService{
    @Autowired
    private RazaAnimalRepository razaAnimalRepository;

    @Override
    public GenericRepository<RazaAnimal, Integer> getDao() {
        return razaAnimalRepository;
    }
}
