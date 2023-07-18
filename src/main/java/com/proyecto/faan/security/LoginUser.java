package com.proyecto.faan.security;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;


}
