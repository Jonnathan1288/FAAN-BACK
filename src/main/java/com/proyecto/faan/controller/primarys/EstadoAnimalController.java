package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.model.primarys.EstadoAnimal;
import com.proyecto.faan.service.generic.GenericService;
import com.proyecto.faan.service.primarys.ControlAnimalService;
import com.proyecto.faan.service.primarys.EstadoAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/estadoAnimal")
public class EstadoAnimalController extends GenericControllerImpl<EstadoAnimal, Integer> {
    @Autowired
    private EstadoAnimalService estadoAnimalService;

    @Override
    protected GenericService<EstadoAnimal, Integer> getService() {
        return estadoAnimalService;
    }

}
