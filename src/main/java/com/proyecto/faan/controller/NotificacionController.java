package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.mongo.Notificacion;
import com.proyecto.faan.payload.PeyloadAlergiasAnimal;
import com.proyecto.faan.service.AlergiasService;
import com.proyecto.faan.service.generic.GenericService;
import com.proyecto.faan.service.mongoService.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class NotificacionController  {
    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/save")
    public ResponseEntity<Notificacion> save(@RequestBody Notificacion notificacion){
        return new ResponseEntity<>(notificacionService.save(notificacion), HttpStatus.CREATED);

    }

}
