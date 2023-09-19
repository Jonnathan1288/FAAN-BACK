package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.payload.AnimalFilter;
import com.proyecto.faan.payload.PeyloadAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.repository.primarys.AnimalRepository;
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
    public Page<PeyloadAnimal> findByAllPlacaOrNombre(Pageable pageable) {
        Page<PeyloadAnimal> findAnimal = animalRepository.findByAllPlacaOrNombre(pageable);
        System.out.printf("llegog asta aqui");
        if(findAnimal != null){
            System.out.printf("llegog asta aquilllololol");
            return findAnimal;
        }
        return null;
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
    public Boolean existsByPlacaAnimal(String placa) {
        return animalRepository.existsByPlacaAnimal(placa);
    }

    //    ====================================================================================
    @Override
    public Page<Animal> AdoptadoOrNoAdoptado(Boolean adoptado, String nombreOrPlaca, Pageable pageable) {
        Page<Animal> findAnimal = null;
        if (adoptado) {
            if (nombreOrPlaca.length() != 0) {
                findAnimal = animalRepository.PlacaONombreAdopciones(nombreOrPlaca, pageable);
            } else {
                findAnimal = animalRepository.Adopciones(pageable);
            }
        } else {
            if (nombreOrPlaca.length() != 0) {
                findAnimal = animalRepository.PlacaONombreNoAdopciones(nombreOrPlaca, pageable);
            } else {
                findAnimal = animalRepository.NoAdopciones(pageable);
            }
        }
        if(findAnimal != null){
            return findAnimal;
        }
        return null;
    }

    @Override
    public List<AnimalFilter> findByEsterilizadoAnimalFilterExport(Boolean esterilizado) {
        return animalRepository.findByEsterilizadoAnimalFilterExport(esterilizado);
    }

    @Override
    public List<AnimalFilter> findByMultipleAttributes(Boolean esterilizado, String status) {
        return animalRepository.findByMultipleAttributes(esterilizado, status);
    }
    //    ====================================================================================

}