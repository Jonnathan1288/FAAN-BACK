package com.proyecto.faan.security.dtos;

import com.proyecto.faan.model.primarys.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDto {
    private String token;
    private UserResponseDto userResponse;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto(String token, UserResponseDto userResponse) {
        this.token = token;
        this.userResponse = userResponse;
    }

}
