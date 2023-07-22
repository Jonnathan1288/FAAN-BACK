package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario,Integer> {

    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaCorreo(String identificacion);

    public Usuario findByTokenPassword(String tokenPassword);
}
