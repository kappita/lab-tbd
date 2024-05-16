package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.Forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.jsonwebtoken.*;
import java.util.Date;
import javax.crypto.SecretKey;

@Repository
public class JWTMiddlewareRepositoryImp implements JWTMiddlewareRepository {
    private final SecretKey secretKey;

    @Autowired
    public JWTMiddlewareRepositoryImp(SecretKey secretKey){
        this.secretKey = secretKey;
    }

    @Override
    public String generateToken(LoginForm form){
        Date expiration_date = new Date(System.currentTimeMillis() + 14400000);

        return Jwts
                .builder()
                .claim("email", form.getEmail())
                .claim("password", form.getPassword())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration_date)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Boolean validateToken(String token){
        try{
            Jws<Claims> jws = Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public LoginForm decodeJWT(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String email = claims.get("email", String.class);
        String password = claims.get("password", String.class);
        return new LoginForm(email, password);
    }
}

