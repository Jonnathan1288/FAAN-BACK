package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.RazaAnimal;
import com.proyecto.faan.model.TipoTratamiento;
import com.proyecto.faan.service.RazaAnimalService;
import com.proyecto.faan.service.TipoTratamientoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoTratamiento")
public class TipoTratamientoController extends GenericControllerImpl<TipoTratamiento, Integer> {
    @Autowired
    private TipoTratamientoService tipoTratamientoService;

    @Override
    protected GenericService<TipoTratamiento, Integer> getService() {
        return tipoTratamientoService;
    }
}
