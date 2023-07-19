package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoVacuna;
import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.peyload.PeyloadTratamientoAnimal;
import com.proyecto.faan.service.TipoVacunaService;
import com.proyecto.faan.service.TratamientoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoController extends GenericControllerImpl<Tratamiento, Integer> {
    @Autowired
    private TratamientoService tratamientoService;

    @Override
    protected GenericService<Tratamiento, Integer> getService() {
        return tratamientoService;
    }
    @GetMapping("/fichamedicaTratamiento/{idFichaMedica}")
    public List<PeyloadTratamientoAnimal> buscarTratamientoPorIdFichaMedica(@PathVariable Integer idFichaMedica) {
        return tratamientoService.buscarTratamientoPorIdFichaMedica(idFichaMedica);
    }
}
