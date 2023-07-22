package com.proyecto.faan.controller.secundary;

import com.proyecto.faan.model.secundary.Notificacion;
import com.proyecto.faan.repository.secundary.notificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class notificacionController {

    @Autowired
    private notificacionRepository notificacionService;

    @PostMapping("/save")
    public ResponseEntity<Notificacion> save(@RequestBody Notificacion notificacion){
        return new ResponseEntity<>(notificacionService.save(notificacion), HttpStatus.CREATED);

    }
}
