package com.proyecto.faan.model.secundary;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private String _id;

    @Field("fechaCreacion")
    private LocalDate fechaCreacion;

    @Field("idUsuario")
    private Integer idUsuario;

    @Field("fullName")
    private String fullName;

    @Field("cuerpoMensaje")
    private String cuerpoMensaje;

    @Field("idMascota")
    private Integer idMascota;

    @Field("placaMasctoa")
    private String placaMasctoa;

    @Field("diasFaltantes")
    private String diasFaltantes;

    @Field("estadoNotifacion")
    private String estadoNotifacion;

    @Field("proximaFechaFacunacion")
    private LocalDate proximaFechaFacunacion;
}