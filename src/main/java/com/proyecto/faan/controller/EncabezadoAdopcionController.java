package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.DetalleAdopcion;
import com.proyecto.faan.model.EncabezadoAdopcion;
import com.proyecto.faan.service.DetalleAdopcionService;
import com.proyecto.faan.service.EncabezadoAdopcionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encabezadoadopcion")
public class EncabezadoAdopcionController extends GenericControllerImpl<EncabezadoAdopcion, Integer> {
    @Autowired
    private EncabezadoAdopcionService encabezadoAdopcionService;
    @Override
    protected GenericService<EncabezadoAdopcion, Integer> getService() {
        return encabezadoAdopcionService;
    }
}
