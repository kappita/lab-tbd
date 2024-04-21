package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciasHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.EmergenciasHabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciasHabilidadService {

    private final EmergenciasHabilidadRepository emergenciaHabilidadRepository;

    public EmergenciasHabilidadService(EmergenciasHabilidadRepository emergenciaHabilidadRepository) {
        this.emergenciaHabilidadRepository = emergenciaHabilidadRepository;
    }

    public List<EmergenciasHabilidadEntity> obtenerEmergenciasHabilidad() {
        return emergenciaHabilidadRepository.getEmergenciasHabilidad();
    }
}
