package com.proyecto.faan.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DatabaseConfig {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseConfig(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void importData() {
        runSQLScript();
    }

    private void runSQLScript() {
        try {
            ClassPathResource resource = new ClassPathResource("import.sql");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<String> sqlStatements = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatements.add(line);
            }

            // Convierte la lista de sentencias en un arreglo de cadenas
            String[] sqlArray = sqlStatements.toArray(new String[0]);

            // Ejecuta todas las sentencias en lote
            jdbcTemplate.batchUpdate(sqlArray);
        } catch (Exception e) {
            System.out.println("Err carga-----------------------------> "+e.getMessage());
            e.printStackTrace();
        }
    }

}
