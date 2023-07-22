package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.TipoTratamiento;
import com.proyecto.faan.service.primarys.TipoTratamientoService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoTratamiento")
public class TipoTratamientoController extends GenericControllerImpl<TipoTratamiento, Integer> {
    @Autowired
    private TipoTratamientoService tipoTratamientoService;

    @Override
    protected GenericService<TipoTratamiento, Integer> getService() {
        return tipoTratamientoService;
    }
}
