package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.service.primarys.UsuarioService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericControllerImpl<Usuario, Integer> {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    protected GenericService<Usuario, Integer> getService() {
        return usuarioService;
    }

    @GetMapping("/existByUsername/{username}")
    public Boolean existByUsername(@PathVariable("username") String username) {
        try {
            return usuarioService.existsByUsername(username);
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/findByIdentificacionOrUsername/filter/{key}")
    public ResponseEntity<?> findByIdentificacionOrUsername(@PathVariable("key") String key , @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            return new ResponseEntity<>(usuarioService.findByPersonaIdentificacionContainingIgnoreCaseOrUsernameContainingIgnoreCase(key, pageable), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pageable/dadmin")
    public ResponseEntity<?> findByAllUsers(Pageable pageable) {
        try {
            return new ResponseEntity<>(usuarioService.findByAllUsers(pageable), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
