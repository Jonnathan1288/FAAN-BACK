package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Animal;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.service.AnimalService;
import com.proyecto.faan.service.DetalleAdopcionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
