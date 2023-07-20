package com.proyecto.faan.repository;

import com.proyecto.faan.model.ExamenFisico;
import com.proyecto.faan.peyload.PeyloadExamenFisicoAnimal;
import com.proyecto.faan.peyload.PeyloadVacunasAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenFisicoRepository extends GenericRepository<ExamenFisico,Integer> {
    @Query("SELECT e.fechaRevisionFisisca as fechaRevisionFisisca, e.peso as peso, e.frecuenciaCardiaca as frecuenciaCardiaca, e.mucosa as mucosa , e.ojosrojos as ojosrojos, e.piel as piel, e.sistemaUrinario as sistemaUrinario, e.sistemaDigestivo as sistemaDigestivo, e.abdomen as abdomen FROM ExamenFisico e JOIN e.fichaMedica f WHERE f.idFichaMedica =:idFichaMedica")
    List<PeyloadExamenFisicoAnimal> findByExamenFisicoFichaMedicaId(Integer idFichaMedica);
}
