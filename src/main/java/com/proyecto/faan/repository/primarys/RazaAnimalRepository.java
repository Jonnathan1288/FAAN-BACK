package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.RazaAnimal;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RazaAnimalRepository extends GenericRepository<RazaAnimal,Integer> {

    public List<RazaAnimal> findByEstadoRaza(@Param("status") String status);
}
