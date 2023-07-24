package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Tratamiento;
import com.proyecto.faan.payload.PeyloadTratamientoAnimal;
import com.proyecto.faan.repository.primarys.TratamientoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoServiceImpl extends GenericServiceImpl<Tratamiento, Integer> implements TratamientoService{
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public GenericRepository<Tratamiento, Integer> getDao() {
        return tratamientoRepository;
    }
    public List<PeyloadTratamientoAnimal> buscarTratamientoPorIdFichaMedica(Integer idFichaMedica) {
        return tratamientoRepository.findByTratamientoFichaMedicaId(idFichaMedica);
    }
}