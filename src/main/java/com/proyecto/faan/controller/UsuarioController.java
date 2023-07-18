package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.service.TratamientoService;
import com.proyecto.faan.service.UsuarioService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericControllerImpl<Usuario, Integer> {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected GenericService<Usuario, Integer> getService() {
        return usuarioService;
    }
}
