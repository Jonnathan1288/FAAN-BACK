package com.proyecto.faan.repository.secundary;

import com.proyecto.faan.model.secundary.Notificacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {

    public List<Notificacion> findByEstadoNotifacion(String estado);

    @Query("{'estadoNotifacion': 'A', 'proximaFechaFacunacion': {$gte: ?0, $lte: ?1}}")
    public List<Notificacion> findNotificacionesProximaVacuna(Date fechaActual, Date fechaFutura);
}