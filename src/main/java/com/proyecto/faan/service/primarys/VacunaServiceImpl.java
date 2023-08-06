package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Vacuna;
import com.proyecto.faan.model.secundary.Notificacion;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.repository.primarys.VacunaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.repository.secundary.NotificacionRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacunaServiceImpl extends GenericServiceImpl<Vacuna, Integer> implements VacunaService {
    @Autowired
    private VacunaRepository vacunaRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public GenericRepository<Vacuna, Integer> getDao() {
        return vacunaRepository;
    }



}
