package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.repositories.AgregarVoluntarioDisponibleRepository;
import org.springframework.stereotype.Service;


@Service

public class AgregarVoluntarioDisponibleService {

    private final AgregarVoluntarioDisponibleRepository agregarVoluntarioDisponibleRepository;

    public AgregarVoluntarioDisponibleService(AgregarVoluntarioDisponibleRepository agregarVoluntarioDisponibleRepository) {
        this.agregarVoluntarioDisponibleRepository = agregarVoluntarioDisponibleRepository;
    }

    public void postularComoDisponible(int idEmergencia, String emailVoluntario) {
        agregarVoluntarioDisponibleRepository.postularComoDisponible(idEmergencia, emailVoluntario);
    }
}
