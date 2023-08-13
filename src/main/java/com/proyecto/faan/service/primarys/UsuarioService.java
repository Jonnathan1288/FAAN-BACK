package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.service.generic.GenericService;

public interface UsuarioService extends GenericService<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaEmail(String identificacion);

    public Usuario findByTokenPassword(String tokenPassword);
}
