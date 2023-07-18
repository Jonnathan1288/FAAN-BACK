package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.model.Vacuna;
import com.proyecto.faan.peyload.PeyloadVacunasAnimal;
import com.proyecto.faan.service.UsuarioService;
import com.proyecto.faan.service.VacunaService;
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

    @GetMapping("/fichamedica/{idFichaMedica}")
    public List<PeyloadVacunasAnimal> buscarVacunasPorIdFichaMedica(@PathVariable Integer idFichaMedica) {
        return vacunaService.buscarVacunasPorIdFichaMedica(idFichaMedica);
    }
}
