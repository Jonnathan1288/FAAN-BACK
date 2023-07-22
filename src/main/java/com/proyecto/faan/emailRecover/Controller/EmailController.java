package com.proyecto.faan.emailRecover.Controller;


import com.proyecto.faan.emailRecover.Dtos.CambiarPasswordDTO;
import com.proyecto.faan.emailRecover.Dtos.EmailValuesDTO;
import com.proyecto.faan.emailRecover.Services.EmailServiceImpl;
import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.service.primarys.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private UsuarioService usuarioService;

    @Value("${spring.mail.username}")
    private String sendFrom;


   // @Autowired
    //private PasswordEncoder passwordEncoder;


      @GetMapping("/email/sendRecuperacionPassword/{email}")
    public ResponseEntity<?> sendEmailRecuperacion(@PathVariable("email") String email){

        try {
            Usuario usuario = usuarioService.findByPersonaEmail(email);
            if (usuario == null) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND_USUARIO");
            }
            EmailValuesDTO values = new EmailValuesDTO();
            values.setMailFrom(sendFrom);
            values.setMailTo(usuario.getPersona().getCorreo());
            values.setUsername(usuario.getPersona().getNombre1() + ' ' + usuario.getPersona().getNombre2() + ' ' + usuario.getPersona().getApellido1() + ' ' + usuario.getPersona().getApellido2());
            values.setSubject("RESTAURAR CONSTRASEÑA");
            UUID uuid = UUID.randomUUID();
            String tokenPassword  = uuid.toString();
            values.setJwt(tokenPassword);
            usuario.setTokenPassword(tokenPassword);
            if(usuario != null) {
                if(emailService.sendEmail(values) == true) {
                    return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
                }else {
                    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INCONVENIENTE");
                }
            }else {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
            }
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR DE SERVIDOR");
        }

    }

    @PostMapping("/cambiarContraseniaUsuario")
    public ResponseEntity<?> cambiarContraseniaUsuario(@Valid @RequestBody CambiarPasswordDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos mal puestos", HttpStatus.BAD_REQUEST);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return new ResponseEntity<>("No coinciden", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = usuarioService.findByTokenPassword(dto.getTokenPassword());
        if (usuario == null) {
            return new ResponseEntity<>("No encontrado el usuario", HttpStatus.BAD_REQUEST);
        }
        //String passwordNew = passwordEncoder.encode(dto.getPassword());
        //usuario.setPassword(passwordNew);
        usuario.setPassword(dto.getPassword());
        usuario.setTokenPassword(null);
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
    }



}
