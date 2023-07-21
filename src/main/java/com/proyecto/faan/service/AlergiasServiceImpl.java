package com.proyecto.faan.service;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.payload.PeyloadAlergiasAnimal;
import com.proyecto.faan.repository.AlergiasRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiasServiceImpl extends GenericServiceImpl<Alergias, Integer> implements AlergiasService{
    @Autowired
    private AlergiasRepository alergiasRepository;

    @Override
    public GenericRepository<Alergias, Integer> getDao() {
        return alergiasRepository;
    }
    public List<PeyloadAlergiasAnimal> buscarAlergiasPorIdFichaMedica(Integer idFichaMedica) {
        return alergiasRepository.findByAlergiasFichaMedicaId(idFichaMedica);
    }
}