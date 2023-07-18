package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.service.EnfermedadService;
import com.proyecto.faan.service.ExamenFisicoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/examenFisico")
public class ExamenFisicoController extends GenericControllerImpl<ExamenFisico, Integer> {
    @Autowired
    private ExamenFisicoService examenFisicoService;
    @Override
    protected GenericService<ExamenFisico, Integer> getService() {
        return examenFisicoService;
    }
}
