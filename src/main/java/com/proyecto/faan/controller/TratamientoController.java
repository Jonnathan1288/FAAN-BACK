package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoVacuna;
import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.service.TipoVacunaService;
import com.proyecto.faan.service.TratamientoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
