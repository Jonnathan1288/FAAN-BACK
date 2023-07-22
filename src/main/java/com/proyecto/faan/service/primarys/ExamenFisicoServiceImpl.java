package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.ExamenFisico;
import com.proyecto.faan.payload.PeyloadExamenFisicoAnimal;
import com.proyecto.faan.repository.primarys.ExamenFisicoRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenFisicoServiceImpl extends GenericServiceImpl<ExamenFisico, Integer> implements ExamenFisicoService{
    @Autowired
    private ExamenFisicoRepository examenFisicoRepository;

    @Override
    public GenericRepository<ExamenFisico, Integer> getDao() {
        return examenFisicoRepository;
    }

    public List<PeyloadExamenFisicoAnimal> buscarExamenFisicoPorIdFichaMedica(Integer idFichaMedica) {
        return examenFisicoRepository.findByExamenFisicoFichaMedicaId(idFichaMedica);
    }
}