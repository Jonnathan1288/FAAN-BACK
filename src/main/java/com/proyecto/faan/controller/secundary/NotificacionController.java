package com.proyecto.faan.controller.secundary;

import com.proyecto.faan.model.secundary.Notificacion;
import com.proyecto.faan.repository.secundary.NotificacionRepository;
import com.proyecto.faan.service.mongoService.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/notificaciones/save")
    public ResponseEntity<Notificacion> save(@RequestBody Notificacion notificacion){
        return new ResponseEntity<>(notificacionService.save(notificacion), HttpStatus.CREATED);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Notificacion> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(notificacionService.findById(id), HttpStatus.CREATED);
    }

    @GetMapping("updateEstado/notificaciones/{id}")
    public ResponseEntity<Notificacion> updateEstado(@PathVariable("id") String id){
        Notificacion notificacion = notificacionService.findById(id);
        return new ResponseEntity<>(notificacionService.update(id,notificacion), HttpStatus.CREATED);
    }

}
