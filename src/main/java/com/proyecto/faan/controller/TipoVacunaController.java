package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoTratamiento;
import com.proyecto.faan.model.TipoVacuna;
import com.proyecto.faan.service.TipoTratamientoService;
import com.proyecto.faan.service.TipoVacunaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoVacuna")
public class
TipoVacunaController extends GenericControllerImpl<TipoVacuna, Integer> {
    @Autowired
    private TipoVacunaService tipoVacunaService;

    @Override
    protected GenericService<TipoVacuna, Integer> getService() {
        return tipoVacunaService;
    }
}
