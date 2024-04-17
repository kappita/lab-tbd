package Grupo6.VoluntariadoEmergencias.repositories;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Value("${database.url}")
    private String url;

    @Value("${database.user}")
    private String user;

    @Value("${database.pass}")
    private String pass;

    @Bean
    // Agregar datos de la DB
    public Sql2o sql2o() {
        return new Sql2o(url, user, pass);
    }
}