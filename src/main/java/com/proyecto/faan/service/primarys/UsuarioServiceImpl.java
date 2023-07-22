package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.repository.primarys.UsuarioRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public GenericRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario findByPersonaEmail(String identificacion) {
        return usuarioRepository.findByPersonaCorreo(identificacion);
    }

    @Override
    public Usuario findByTokenPassword(String tokenPassword) {
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }
}
