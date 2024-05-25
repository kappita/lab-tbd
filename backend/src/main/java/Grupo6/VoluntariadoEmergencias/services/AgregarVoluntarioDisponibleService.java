package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.Forms.JoinEmergencyForm;
import Grupo6.VoluntariadoEmergencias.entities.Forms.LoginForm;
import Grupo6.VoluntariadoEmergencias.repositories.AgregarVoluntarioDisponibleRepository;
import Grupo6.VoluntariadoEmergencias.repositories.JWTMiddlewareRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class AgregarVoluntarioDisponibleService {

    @Autowired
    private JWTMiddlewareRepositoryImp JWT;

    private final AgregarVoluntarioDisponibleRepository agregarVoluntarioDisponibleRepository;

    public AgregarVoluntarioDisponibleService(AgregarVoluntarioDisponibleRepository agregarVoluntarioDisponibleRepository) {
        this.agregarVoluntarioDisponibleRepository = agregarVoluntarioDisponibleRepository;
    }

    public void postularComoDisponible(JoinEmergencyForm body) {

        if (!JWT.validateToken(body.getToken())) {
            return;
        }
        LoginForm user = JWT.decodeJWT(body.getToken());

        agregarVoluntarioDisponibleRepository.postularComoDisponible(body.getId_emergencia(), user.getEmail());
    }
}
