package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.EncabezadoAdopcion;
import com.proyecto.faan.payload.AdoptedAnimal;
import com.proyecto.faan.payload.AnimalFilter;
import com.proyecto.faan.service.primarys.EncabezadoAdopcionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encabezadoadopcion")
public class EncabezadoAdopcionController extends GenericControllerImpl<EncabezadoAdopcion, Integer> {
    private EncabezadoAdopcionService encabezadoAdopcionService;

    @Autowired
    public EncabezadoAdopcionController(EncabezadoAdopcionService encabezadoAdopcionService){
        this.encabezadoAdopcionService = encabezadoAdopcionService;
    }
    @Override
    protected GenericService<EncabezadoAdopcion, Integer> getService() {
        return encabezadoAdopcionService;
    }

    @GetMapping("/findByAdoptedAnimal/{idAanimal}")
    public ResponseEntity<AdoptedAnimal> findAdoptedAnimal(@PathVariable("idAanimal") Integer idAanimal) {
        try {
            return new ResponseEntity<>(encabezadoAdopcionService.findAdoptedAnimal(idAanimal), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
