package com.proyecto.faan.model.secundary;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private String _id;

    @Field("fullNameMascota")
    private String fullNameMascota;

    @Field("cuerpoMensaje")
    private String cuerpoMensaje;

    @Field("placaMasctoa")
    private String placaMasctoa;

    @Field("diasFaltantes")
    private String diasFaltantes;

    @Field("estadoNotifacion")
    private String estadoNotifacion;

    @Field("proximaFechaFacunacion")
    private Date proximaFechaFacunacion;
}