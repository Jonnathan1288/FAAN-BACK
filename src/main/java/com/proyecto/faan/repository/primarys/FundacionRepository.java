package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Fundacion;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundacionRepository extends GenericRepository<Fundacion,Integer> {
}
