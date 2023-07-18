package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.FichaMedica;
import com.proyecto.faan.model.FichaRegistro;
import com.proyecto.faan.service.FichaMedicaService;
import com.proyecto.faan.service.FichaRegistroService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fichaRegistro")
public class FichaRegistroController extends GenericControllerImpl<FichaRegistro, Integer> {
    @Autowired
    private FichaRegistroService fichaRegistroService;

    @Override
    protected GenericService<FichaRegistro, Integer> getService() {
        return fichaRegistroService;
    }
}
