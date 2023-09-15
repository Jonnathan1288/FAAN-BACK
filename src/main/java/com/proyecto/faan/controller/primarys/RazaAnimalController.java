package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.model.primarys.TipoAnimal;
import com.proyecto.faan.service.primarys.RazaAnimalService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/razaAnimal")
public class RazaAnimalController extends GenericControllerImpl<RazaAnimal, Integer> {
    private RazaAnimalService razaAnimalService;

    @Autowired
    public RazaAnimalController(RazaAnimalService razaAnimalService){
        this.razaAnimalService = razaAnimalService;
    }

    @Override
    protected GenericService<RazaAnimal, Integer> getService() {
        return razaAnimalService;
    }

    @GetMapping("/status")
    public ResponseEntity<List<RazaAnimal>> findByAllStatus() {
        try {
            return new ResponseEntity<>(razaAnimalService.findByEstadoRaza(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
