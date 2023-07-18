package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Persona;
import com.proyecto.faan.peyload.PeyloadAlergiasAnimal;
import com.proyecto.faan.service.AlergiasService;
import com.proyecto.faan.service.PersonaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/alergias")
public class AlergiasController extends GenericControllerImpl<Alergias, Integer> {
    @Autowired
    private AlergiasService alergiasService;
    @Override
    protected GenericService<Alergias, Integer> getService() {
        return alergiasService;
    }
    @GetMapping("/fichamedicaAlergias/{idFichaMedica}")
    public List<PeyloadAlergiasAnimal> buscarAlergiasPorIdFichaMedica(@PathVariable Integer idFichaMedica) {
        return alergiasService.buscarAlergiasPorIdFichaMedica(idFichaMedica);
    }
}
