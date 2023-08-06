package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.service.generic.GenericService;
import com.proyecto.faan.service.primarys.AnimalService;
import com.proyecto.faan.service.primarys.ControlAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/controlAnimal")
public class ControlAnimalController extends GenericControllerImpl<ControlAnimal, Integer> {
    @Autowired
    private ControlAnimalService controlAnimalService;

    @Override
    protected GenericService<ControlAnimal, Integer> getService() {
        return controlAnimalService;
    }

}
