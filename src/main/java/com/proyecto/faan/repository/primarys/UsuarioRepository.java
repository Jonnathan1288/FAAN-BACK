package com.proyecto.faan.repository.primarys;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario,Integer> {

    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaCorreo(String email);

    public Usuario findByTokenPassword(String tokenPassword);

    public Boolean existsByUsername(String username);

    public Page<Usuario> findByPersonaIdentificacionContainingIgnoreCaseOrUsernameContainingIgnoreCase(String ci, String username, Pageable pageable);
}
