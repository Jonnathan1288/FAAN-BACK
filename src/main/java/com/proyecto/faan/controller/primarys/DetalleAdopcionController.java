package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.DetalleAdopcion;
import com.proyecto.faan.service.primarys.DetalleAdopcionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //    ====================================================================================
    @GetMapping("/findByIdAnimal/{idAnimal}")
    public ResponseEntity<?> findByIdAnimal(@PathVariable("idAnimal") Integer idAnimal) {
        try {
            DetalleAdopcion detalleAdopcion = detalleAdopcionService.findByIdAnimal(idAnimal);

            if(detalleAdopcion != null){
                return new ResponseEntity<>(detalleAdopcion, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/existIdAnimal/{idAnimal}")
    public ResponseEntity<Boolean> existIdAnimal(@PathVariable("idAnimal") Integer idAnimal) {
        try {
            DetalleAdopcion detalleAdopcion = detalleAdopcionService.findByIdAnimal(idAnimal);

            if(detalleAdopcion != null){
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    ====================================================================================

}
