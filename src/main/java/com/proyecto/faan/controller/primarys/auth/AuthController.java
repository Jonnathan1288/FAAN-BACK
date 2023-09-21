package com.proyecto.faan.controller.primarys.auth;

import com.proyecto.faan.model.primarys.Usuario;
import com.proyecto.faan.repository.primarys.UsuarioRepository;
import com.proyecto.faan.security.dtos.JwtDto;
import com.proyecto.faan.security.dtos.LoginUser;
import com.proyecto.faan.security.dtos.UserResponseDto;
import com.proyecto.faan.security.jwt.JwtProvider;
import com.proyecto.faan.security.model.Message;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    private UsuarioRepository userService;

    private JwtProvider jwtProvider;

    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, UsuarioRepository userService, JwtProvider jwtProvider){
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signIn")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {
        if (bidBindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Usuario user = userService.findByUsername(userDetails.getUsername());
            UserResponseDto responseDto = new UserResponseDto(user.getIdUsuario(), user.getUsername(), user.getFotoPerfil(), user.getEstadoUsuario(), user.getRoles());
            JwtDto jwtDto = new JwtDto(jwt, user);
            return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Revise sus credenciales " + e), HttpStatus.BAD_REQUEST);
        }
    }

}
