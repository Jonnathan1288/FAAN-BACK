package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.TipoAlergias;
import com.proyecto.faan.service.TipoAlergiasService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoalergias")
public class TipoAlergiasController extends GenericControllerImpl<TipoAlergias, Integer> {
    @Autowired
    private TipoAlergiasService tipoAlergiasService;
    @Override
    protected GenericService<TipoAlergias, Integer> getService() {
        return tipoAlergiasService;
    }
}
