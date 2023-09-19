package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService extends GenericService<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaEmail(String identificacion);

    public Usuario findByTokenPassword(String tokenPassword);

    public Boolean existsByUsername(String username);

    public Page<Usuario> findByPersonaIdentificacionContainingIgnoreCaseOrUsernameContainingIgnoreCase(String key, Pageable pageable);

}
