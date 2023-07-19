package com.proyecto.faan.repository;

import com.proyecto.faan.model.Enfermedad;
import com.proyecto.faan.peyload.PeyloadEnfermedadAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfermedadRepository extends GenericRepository<Enfermedad,Integer> {
    @Query("SELECT tipo.nombreEnfermedad as nombreEnfermedad, e.fechaEnfermedad as fechaEnfermedad, e.observaciones as observaciones, e.estadoEnfermedad as estadoEnfermedad FROM enfermedades e JOIN e.tipoEnfermedad tipo JOIN e.fichaMedica f WHERE f.idFichaMedica =:idFichaMedica")
    List<PeyloadEnfermedadAnimal> findByEnfermedadFichaMedicaId(Integer idFichaMedica);
}
