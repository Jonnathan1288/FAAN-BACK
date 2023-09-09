package com.proyecto.faan.emailRecover.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.faan.emailRecover.Dtos.CambiarPasswordDTO;
import com.proyecto.faan.emailRecover.Dtos.EmailValuesDTO;
import com.proyecto.faan.emailRecover.MessageCode.Message;
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

    private final ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/email/sendRecuperacionPassword/{email}")
    public ResponseEntity<?> sendEmailRecuperacion(@PathVariable("email") String email){

        try {
            Usuario usuario = usuarioService.findByPersonaEmail(email);
            if (usuario == null) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Message.ERROR_404);
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

            if(emailService.sendEmail(values) == true) {
                usuarioService.save(usuario);
                String responseBody = objectMapper.writeValueAsString(Message.SUCCESSFUL_200);
                return ResponseEntity.status(HttpStatus.OK).body(responseBody);
            }else {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.ERROR_400);
            }

        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Message.ERROR_500);
        }

    }

    @PostMapping("/cambiarContraseniaUsuario")
    public ResponseEntity<?> cambiarContraseniaUsuario(@Valid @RequestBody CambiarPasswordDTO dto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Campos mal puestos", HttpStatus.BAD_REQUEST);
            }
            if (!dto.getPassword().equals(dto.getPasswordr())) {
                return new ResponseEntity<>("No coinciden", HttpStatus.BAD_REQUEST);
            }
            Usuario usuario = usuarioService.findByTokenPassword(dto.getToken());
            if (usuario == null) {
                return new ResponseEntity<>("No encontrado el usuario", HttpStatus.NOT_FOUND);
            }
            //String passwordNew = passwordEncoder.encode(dto.getPassword());
            //usuario.setPassword(passwordNew);
            usuario.setPassword(dto.getPassword());
            usuario.setTokenPassword(null);
            usuarioService.save(usuario);
            return new ResponseEntity<>(objectMapper.writeValueAsString("SUCCESSFUL"), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
