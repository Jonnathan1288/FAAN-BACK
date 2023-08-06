package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Vacuna;
import com.proyecto.faan.payload.PeyloadVacunasAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacunaRepository extends GenericRepository<Vacuna,Integer> {

}
