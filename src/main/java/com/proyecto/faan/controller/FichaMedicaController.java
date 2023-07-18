package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.model.FichaMedica;
import com.proyecto.faan.service.ExamenFisicoService;
import com.proyecto.faan.service.FichaMedicaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fichaMedica")
public class FichaMedicaController extends GenericControllerImpl<FichaMedica, Integer> {
    @Autowired
    private FichaMedicaService fichaMedicaService;
    @Override
    protected GenericService<FichaMedica, Integer> getService() {
        return fichaMedicaService;
    }
}
