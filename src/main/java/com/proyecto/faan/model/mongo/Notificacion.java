package com.proyecto.faan.model.mongo;


import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private String id;

    private String fecha;
    private String nombre;
}
