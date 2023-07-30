package com.proyecto.faan.service;

import com.proyecto.faan.model.Animal;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.repository.AnimalRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl extends GenericServiceImpl<Animal, Integer> implements AnimalService{
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public GenericRepository<Animal, Integer> getDao() {
        return animalRepository;
    }

    public List<PeyloadNumeroAdopcionRaza> findByAnimalPeyload() {
        return animalRepository.findByAnimalPeyload();
    }

    public List<PeyloadNumeroAdopcionFecha> findByAnimalPeyloadFechaAdopcion() {
        return animalRepository.findByAnimalPeyloadFechaAdopcion();
    }

    @Override
    public Page<Animal> findByNombreAnimalOrPlacaAnimal(String filter, Pageable pageable) {
        return animalRepository.findByNombreAnimalContainingIgnoreCaseOrPlacaAnimalContainingIgnoreCase(filter, filter, pageable);
    }

    @Override
    public Page<PeyloadAnimal> findByPlacaOrNombre(String filter, Pageable pageable) {
        Page<PeyloadAnimal> findAnimal = animalRepository.findByPlacaOrNombre(filter, pageable);

        if(findAnimal != null){
            return findAnimal;
        }
        return null;
    }

    @Override
    public Page<Animal> AdoptadoOrNoAdoptado(Boolean adoptado, String nombreOrPlaca, Pageable pageable) {
        Page<Animal> findAnimal = null;
        if (adoptado) {
            if (nombreOrPlaca.length() != 0) {
                System.out.println("sssssssssssssssssssssss  1");
                findAnimal = animalRepository.PlacaONombreAdopciones(nombreOrPlaca, pageable);
            } else {
                findAnimal = animalRepository.Adopciones(pageable);
            }
        } else {
            if (nombreOrPlaca.length() != 0) {
                System.out.println("sssssssssssssssssssssss  2");
                findAnimal = animalRepository.PlacaONombreNoAdopciones(nombreOrPlaca, pageable);
            } else {
                findAnimal = animalRepository.NoAdopciones(pageable);
            }
        }
        if(findAnimal != null){
            return findAnimal;
        } else {
            System.out.println("sssssssssssssssssssssss  3");
        }
        return null;
    }
}