package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.Forms.LoginForm;

public interface JWTMiddlewareRepository {
    public String generateToken(LoginForm form);
    public Boolean validateToken(String token);
    public LoginForm decodeJWT(String token);
}
