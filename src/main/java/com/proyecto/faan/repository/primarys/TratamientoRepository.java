package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Tratamiento;
import com.proyecto.faan.payload.PeyloadTratamientoAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TratamientoRepository extends GenericRepository<Tratamiento,Integer> {
    @Query("SELECT tipo.nombreTratamiento as nombreTratamiento, a.fechaTratamiento as fechaTratamiento, a.observaciones as observaciones, a.estadoTratamiento as estadoTratamiento FROM tratamientos a JOIN a.tipoTratamiento tipo JOIN a.fichaMedica f WHERE f.idFichaMedica =:idFichaMedica")
    List<PeyloadTratamientoAnimal> findByTratamientoFichaMedicaId(Integer idFichaMedica);
}
