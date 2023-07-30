package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Animal;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.peyload.PeyloadAnimal;
import com.proyecto.faan.service.AnimalService;
import com.proyecto.faan.service.DetalleAdopcionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/detalleadopcion")
public class DetalleAdopcionController extends GenericControllerImpl<DetalleAdopcion, Integer> {
    @Autowired
    private DetalleAdopcionService detalleAdopcionService;
    @Override
    protected GenericService<DetalleAdopcion, Integer> getService() {
        return detalleAdopcionService;
    }


    @GetMapping("/findByIdAnimal/{idAnimal}")
    public ResponseEntity<?> findByIdAnimal(@PathVariable("idAnimal") Integer idAnimal) {
        try {
            DetalleAdopcion detalleAdopcion = detalleAdopcionService.findByIdAnimal(idAnimal);

            if(detalleAdopcion != null){
                return new ResponseEntity<>(detalleAdopcion, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
