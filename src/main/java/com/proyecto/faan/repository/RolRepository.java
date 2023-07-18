package com.proyecto.faan.repository;

import com.proyecto.faan.model.RazaAnimal;
import com.proyecto.faan.model.Rol;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends GenericRepository<Rol,Integer> {
}
