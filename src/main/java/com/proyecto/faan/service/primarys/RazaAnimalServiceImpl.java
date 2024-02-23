package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.repository.primarys.RazaAnimalRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaAnimalServiceImpl extends GenericServiceImpl<RazaAnimal, Integer> implements RazaAnimalService{
    @Autowired
    private RazaAnimalRepository razaAnimalRepository;

    @Override
    public GenericRepository<RazaAnimal, Integer> getDao() {
        return razaAnimalRepository;
    }

    @Override
    public List<RazaAnimal> findByEstadoRaza() {
        return razaAnimalRepository.findByEstadoRaza("A");
    }
}
