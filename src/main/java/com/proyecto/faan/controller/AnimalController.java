package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Animal;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.peyload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.service.AnimalService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/animal")
public class AnimalController extends GenericControllerImpl<Animal, Integer> {
    @Autowired
    private AnimalService animalService;
    @Override
    protected GenericService<Animal, Integer> getService() {
        return animalService;
    }

    @GetMapping("/lista/PeyloadNumeroAdopcionRaza")
    public List<PeyloadNumeroAdopcionRaza> obtenerLista() {
        return animalService.findByAnimalPeyload();
    }

    @GetMapping("/lista/PeyloadNumeroAdopcionFecha")
    public List<PeyloadNumeroAdopcionFecha> findByAnimalPeyloadFechaAdopcion() {
        return animalService.findByAnimalPeyloadFechaAdopcion();
    }

    @GetMapping("/findBynameAnimalOrPlacaAnimal/{filter}")
    public ResponseEntity<?> findBynameAnimalOrPlacaAnimal(@PathVariable("filter") String filter, @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            Page<Animal> animalFind;

            if(filter.isEmpty()){
                return new ResponseEntity<>(animalService.findByAll(pageable), HttpStatus.OK);
            }else{
                animalFind = animalService.findByNombreAnimalOrPlacaAnimal(filter, pageable);
            }
            if(animalFind != null){
                return new ResponseEntity<>(animalFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBynameOrplaca/{filter}")
    public ResponseEntity<?> findBynameOrplaca(@PathVariable("filter") String filter, @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            Page<PeyloadAnimal> animalFind = animalService.findByPlacaOrNombre(filter, pageable);

            if(animalFind != null){
                return new ResponseEntity<>(animalFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
