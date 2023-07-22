package com.proyecto.faan.repository.mongoRepository;

import com.proyecto.faan.model.mongo.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
}
