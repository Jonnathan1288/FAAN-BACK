package com.proyecto.faan.service.mongoService;


import com.proyecto.faan.model.secundary.Notificacion;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.repository.secundary.NotificacionRepository;
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

    @Override
    public Notificacion update(String id, Notificacion notificacion) {
        Notificacion notificacionFound = notificacionRepository.findById(id).orElseThrow(RuntimeException::new);
        notificacionFound.setEstadoNotifacion("V");
        return notificacionRepository.save(notificacionFound);
    }

    @Override
    public Notificacion findById(String id) {
        return notificacionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
