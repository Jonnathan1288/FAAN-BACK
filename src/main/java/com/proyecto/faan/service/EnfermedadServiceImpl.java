package com.proyecto.faan.service;

import com.proyecto.faan.model.EncabezadoAdopcion;
import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.peyload.PeyloadEnfermedadAnimal;
import com.proyecto.faan.repository.EncabezadoAdopcionRepository;
import com.proyecto.faan.repository.EnfermedadRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadServiceImpl extends GenericServiceImpl<Enfermedad, Integer> implements EnfermedadService{
    @Autowired
    private EnfermedadRepository enfermedadRepository;

    @Override
    public GenericRepository<Enfermedad, Integer> getDao() {
        return enfermedadRepository;
    }
    public List<PeyloadEnfermedadAnimal> buscarEnfermedadPorIdFichaMedica(Integer idFichaMedica) {
        return enfermedadRepository.findByEnfermedadFichaMedicaId(idFichaMedica);
    }
}