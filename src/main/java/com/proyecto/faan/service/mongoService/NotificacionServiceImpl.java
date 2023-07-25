package com.proyecto.faan.service.mongoService;


import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.mongo.Notificacion;
import com.proyecto.faan.repository.AlergiasRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.repository.mongoRepository.NotificacionRepository;
import com.proyecto.faan.service.generic.GenericService;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionServiceImpl  implements NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;


    @Override
    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }
}
