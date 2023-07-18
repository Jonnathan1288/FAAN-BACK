package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.EncabezadoAdopcion;
import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.service.EncabezadoAdopcionService;
import com.proyecto.faan.service.EnfermedadService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/enfermedad")
public class EnfermedadController extends GenericControllerImpl<Enfermedad, Integer> {
    @Autowired
    private EnfermedadService enfermedadService;
    @Override
    protected GenericService<Enfermedad, Integer> getService() {
        return enfermedadService;
    }
}
