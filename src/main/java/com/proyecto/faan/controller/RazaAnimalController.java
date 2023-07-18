package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.FichaRegistro;
import com.proyecto.faan.model.RazaAnimal;
import com.proyecto.faan.service.FichaRegistroService;
import com.proyecto.faan.service.RazaAnimalService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/razaAnimal")
public class RazaAnimalController extends GenericControllerImpl<RazaAnimal, Integer> {
    @Autowired
    private RazaAnimalService razaAnimalService;

    @Override
    protected GenericService<RazaAnimal, Integer> getService() {
        return razaAnimalService;
    }
}
