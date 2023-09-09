package com.proyecto.faan.emailRecover.Dtos;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class CambiarPasswordDTO {

    @NotBlank
    private String password;
    @NotBlank
    private String passwordr;
    @NotBlank
    private String token;


}
