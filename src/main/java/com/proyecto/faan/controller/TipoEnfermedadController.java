package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoEnfermedad;
import com.proyecto.faan.service.TipoEnfermedadService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoenfermedad")
public class TipoEnfermedadController extends GenericControllerImpl<TipoEnfermedad, Integer> {
    @Autowired
    private TipoEnfermedadService tipoEnfermedadService;
    @Override
    protected GenericService<TipoEnfermedad, Integer> getService() {
        return tipoEnfermedadService;
    }
}
