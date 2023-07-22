package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Rol;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends GenericRepository<Rol,Integer> {
}
