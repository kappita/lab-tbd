package Grupo6.VoluntariadoEmergencias.repositories;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import javax.crypto.SecretKey;


@Configuration
public class DatabaseContext {
    @Value("${database.url}")
    private String url;

    @Value("${database.user}")
    private String user;

    @Value("${database.pass}")
    private String pass;

    @Value("${jwt.secret}")
    private String secret;


    @Bean
    // Agregar datos de la DB
    public Sql2o sql2o() {
        return new Sql2o(url, user, pass);
    }

    @Bean
    public SecretKey secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
