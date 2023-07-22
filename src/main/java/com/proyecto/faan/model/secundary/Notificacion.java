package com.proyecto.faan.model.secundary;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notificaciones")
public class Notificacion {
    @Id
    private String _id;
    private String fecha;
    private String nombre;
}
