package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Animal;
import com.proyecto.faan.model.primarys.ControlAnimal;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionFecha;
import com.proyecto.faan.payload.PeyloadNumeroAdopcionRaza;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlAnimalRepository extends GenericRepository<ControlAnimal,Integer> {


}
