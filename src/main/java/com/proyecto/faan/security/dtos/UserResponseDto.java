package com.proyecto.faan.security.dtos;

import com.proyecto.faan.model.primarys.Rol;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Integer idUsuario;
    private String username;
    private String urlPhoto;
    private Boolean status;
    private List<Rol> roles = new ArrayList<>();
}

