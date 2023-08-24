package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Rol;
import com.proyecto.faan.service.primarys.RolService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rol")
public class RolController extends GenericControllerImpl<Rol, Integer> {
    @Autowired
    private RolService rolService;
    @Override
    protected GenericService<Rol, Integer> getService() {
        return rolService;
    }
}
