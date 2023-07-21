package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.payload.PeyloadEnfermedadAnimal;
import com.proyecto.faan.service.EnfermedadService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/enfermedad")
public class EnfermedadController extends GenericControllerImpl<Enfermedad, Integer> {
    @Autowired
    private EnfermedadService enfermedadService;
    @Override
    protected GenericService<Enfermedad, Integer> getService() {
        return enfermedadService;
    }
    @GetMapping("/fichamedicaEnfermedad/{idFichaMedica}")
    public List<PeyloadEnfermedadAnimal> buscarEnfermedadPorIdFichaMedica(@PathVariable Integer idFichaMedica) {
        return enfermedadService.buscarEnfermedadPorIdFichaMedica(idFichaMedica);
    }
}
