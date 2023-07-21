package com.proyecto.faan.repository;

import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.payload.PeyloadAlergiasAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlergiasRepository extends GenericRepository<Alergias,Integer> {
    @Query("SELECT tipo.nombreAlergia as nombreAlergias, a.fechaDeteccion as fechaAlergias, a.observacion as observaciones, tipo.estado as estado FROM Alergias a JOIN a.tipoAlergias tipo JOIN a.fichaMedica f WHERE f.idFichaMedica =:idFichaMedica")
    List<PeyloadAlergiasAnimal> findByAlergiasFichaMedicaId(Integer idFichaMedica);
}
