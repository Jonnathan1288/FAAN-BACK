package com.proyecto.faan.service;

import com.proyecto.faan.model.Vacuna;
import com.proyecto.faan.repository.VacunaRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacunaServiceImpl extends GenericServiceImpl<Vacuna, Integer> implements VacunaService {
    @Autowired
    private VacunaRepository vacunaRepository;

    @Override
    public GenericRepository<Vacuna, Integer> getDao() {
        return vacunaRepository;
    }
}
