package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.payload.PeyloadExamenFisicoAnimal;
import com.proyecto.faan.service.ExamenFisicoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/examenFisico")
public class ExamenFisicoController extends GenericControllerImpl<ExamenFisico, Integer> {
    @Autowired
    private ExamenFisicoService examenFisicoService;
    @Override
    protected GenericService<ExamenFisico, Integer> getService() {
        return examenFisicoService;
    }

    @GetMapping("/fichamedicaExamenFisico/{idFichaMedica}")
    public List<PeyloadExamenFisicoAnimal> buscarExamenFisicoPorIdFichaMedica(@PathVariable Integer idFichaMedica) {
        return examenFisicoService.buscarExamenFisicoPorIdFichaMedica(idFichaMedica);
    }
}
