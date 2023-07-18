package com.proyecto.faan.service;

import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.service.generic.GenericService;

public interface UsuarioService extends GenericService<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByPersonaEmail(String identificacion);

    public Usuario findByTokenPassword(String tokenPassword);
}
