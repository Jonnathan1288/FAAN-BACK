package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.payload.AnimalFilter;
import com.proyecto.faan.payload.PeyloadAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.service.primarys.AnimalService;
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
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }
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

    @GetMapping("/findBynameOrplaca")
    public ResponseEntity<?> findBynameOrplaca(@RequestParam(required = false) String filter, @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            if(filter == null){
                return new ResponseEntity<>(animalService.findByAllPlacaOrNombre(pageable), HttpStatus.OK);
            }

            Page<PeyloadAnimal> animalFind = animalService.findByPlacaOrNombre(filter, pageable);
            if(animalFind != null){
                return new ResponseEntity<>(animalFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            System.out.printf(""+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/exitPlaca/{placa}")
    public Boolean existPlacaAnimal(@PathVariable("placa") String placa){
        try {
            if(animalService.existsByPlacaAnimal(placa)){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    //    ====================================================================================
    @GetMapping("/findByAdoptadoOrNoAdoptado/{adoptado}")
    public ResponseEntity<?> AdoptadoOrNoAdoptadoAll(@PathVariable("adoptado") Boolean adoptado, @RequestParam(value = "busqueda", defaultValue = "", required = false) String NombreOrPlaca, @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            Page<Animal> animalFind = animalService.AdoptadoOrNoAdoptado(adoptado, NombreOrPlaca, pageable);

            if(animalFind != null){
                return new ResponseEntity<>(animalFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    ====================================================================================


    @GetMapping("/findByEsterilizadoFilter/{key}")
    public ResponseEntity<List<AnimalFilter>> findByAnimalEsterilizadoFilter(@PathVariable("key") Boolean key) {
        try {
            return new ResponseEntity<>(animalService.findByEsterilizadoAnimalFilterExport(key), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByMultipleAtributesFilter")
    public ResponseEntity<List<AnimalFilter>> findByMultipleAtributesFilter(@RequestParam(value = "key", required = false) Boolean key, @RequestParam(value = "status", required = false) String status) {
        System.out.println("key-> "+key);
        try {
            return new ResponseEntity<>(animalService.findByMultipleAttributes(key, status), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
