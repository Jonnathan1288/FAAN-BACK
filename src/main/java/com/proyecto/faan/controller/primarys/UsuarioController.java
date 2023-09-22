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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericControllerImpl<Usuario, Integer> {
    private UsuarioService usuarioService;

    private PasswordEncoder passwordEncoder;
    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder){
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected GenericService<Usuario, Integer> getService() {
        return usuarioService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<Usuario> save(@RequestBody Usuario c) {
        try {
            c.setPassword(passwordEncoder.encode(c.getPassword()));
            return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/data/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        try {

            Usuario usuario1 = usuarioService.findById(id);
            if(usuario1 != null){

                if(usuario.getPassword().equals(usuario1.getPassword())){
                    usuario1.setPassword(usuario.getPassword());
                }else{
                    usuario1.setPassword(passwordEncoder.encode(usuario.getPassword()));
                }

                usuario1.setUsername(usuario.getUsername());
                usuario1.setFotoPerfil(usuario.getFotoPerfil());
                usuario1.setEstadoUsuario(usuario.getEstadoUsuario());
                usuario1.setRoles(usuario.getRoles());

                return new ResponseEntity<>(usuarioService.save(usuario1), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
