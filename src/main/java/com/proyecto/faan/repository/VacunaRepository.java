package com.proyecto.faan.repository;

import com.proyecto.faan.model.Vacuna;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacunaRepository extends GenericRepository<Vacuna,Integer> {
    @Query("SELECT tipo.nombreVacuna as nombreVacuna, a.fechaVacuna as fechaVacuna, a.observaciones as observaciones, a.estadoVacuna as estadoVacuna FROM vacunas a JOIN a.tipoVacuna tipo JOIN a.fichaMedica f WHERE f.idFichaMedica =:idFichaMedica")
    List<PeyloadVacunasAnimal> findByFichaMedicaId(Integer idFichaMedica);

}
