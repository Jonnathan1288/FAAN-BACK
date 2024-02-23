package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.TipoVacuna;
import com.proyecto.faan.service.primarys.TipoVacunaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoVacuna")
public class TipoVacunaController extends GenericControllerImpl<TipoVacuna, Integer> {
    @Autowired
    private TipoVacunaService tipoVacunaService;

    @Override
    protected GenericService<TipoVacuna, Integer> getService() {
        return tipoVacunaService;
    }
}
