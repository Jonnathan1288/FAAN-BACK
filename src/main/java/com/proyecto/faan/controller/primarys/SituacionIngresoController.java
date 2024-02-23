package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.SituacionIngreso;
import com.proyecto.faan.service.primarys.SituacionIngresoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/situacioningreso")
public class SituacionIngresoController extends GenericControllerImpl<SituacionIngreso, Integer> {
    @Autowired
    private SituacionIngresoService situacionIngresoService;
    @Override
    protected GenericService<SituacionIngreso, Integer> getService() {
        return situacionIngresoService;
    }
}
