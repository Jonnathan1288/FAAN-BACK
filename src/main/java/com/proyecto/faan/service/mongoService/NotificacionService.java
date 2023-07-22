package com.proyecto.faan.service.mongoService;


import com.proyecto.faan.model.mongo.Notificacion;
import com.proyecto.faan.service.generic.GenericService;

public interface NotificacionService{
    public Notificacion save(Notificacion notificacion);
}
