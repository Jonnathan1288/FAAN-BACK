package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Vacuna;
import com.proyecto.faan.payload.PeyloadNumeroAnimalTipo;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.service.primarys.VacunaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vacuna")
public class VacunaController extends GenericControllerImpl<Vacuna, Integer> {
    @Autowired
    private VacunaService vacunaService;

    @Override
    protected GenericService<Vacuna, Integer> getService() {
        return vacunaService;
    }

    @GetMapping("/peyload/vacunasanimal/{idControlAnimal}")
    public List<PeyloadVacunasAnimal> AnimalesByVacuna(Integer idControlAnimal) {
        return vacunaService.AnimalesByVacuna(idControlAnimal);
    }

}
