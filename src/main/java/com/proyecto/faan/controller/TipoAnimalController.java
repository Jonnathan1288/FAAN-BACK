package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoAnimal;
import com.proyecto.faan.service.TipoAnimalService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoanimal")
public class TipoAnimalController extends GenericControllerImpl<TipoAnimal, Integer> {
    @Autowired
    private TipoAnimalService tipoAnimalService;
    @Override
    protected GenericService<TipoAnimal, Integer> getService() {
        return tipoAnimalService;
    }
}
