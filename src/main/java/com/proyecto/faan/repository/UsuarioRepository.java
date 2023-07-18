package com.proyecto.faan.repository;

import com.proyecto.faan.model.Tratamiento;
import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario,Integer> {

    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaCorreo(String identificacion);

    public Usuario findByTokenPassword(String tokenPassword);
}
