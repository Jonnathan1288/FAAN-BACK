package com.proyecto.faan.repository.secundary;

import com.proyecto.faan.model.secundary.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notificacionRepository extends MongoRepository<Notificacion, String> {
}