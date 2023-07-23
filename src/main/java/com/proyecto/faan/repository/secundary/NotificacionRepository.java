package com.proyecto.faan.repository.secundary;

import com.proyecto.faan.model.secundary.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {

    public List<Notificacion> findByEstadoNotifacion(String estado);
}