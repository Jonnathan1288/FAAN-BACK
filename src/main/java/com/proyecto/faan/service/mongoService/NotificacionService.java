package com.proyecto.faan.service.mongoService;


import com.proyecto.faan.model.secundary.Notificacion;
import com.proyecto.faan.service.generic.GenericService;

public interface NotificacionService{
    public Notificacion save(Notificacion notificacion);

    public Notificacion update(String id, Notificacion notificacion);

    public Notificacion findById(String id);
}
