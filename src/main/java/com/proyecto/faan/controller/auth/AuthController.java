package com.proyecto.faan.controller.auth;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Alergias;
import com.proyecto.faan.model.Usuario;
import com.proyecto.faan.security.LoginUser;
import com.proyecto.faan.service.AlergiasService;
import com.proyecto.faan.service.UsuarioService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/signIn")
    public ResponseEntity<Usuario> signIn(@RequestBody LoginUser loginUser) {
        try {
            Usuario userfind = usuarioService.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
            if(userfind != null){
                return new ResponseEntity<>(userfind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
