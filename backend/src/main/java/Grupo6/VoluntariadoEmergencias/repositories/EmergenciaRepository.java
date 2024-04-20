package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmergenciaRepository {

    List<EmergenciaEntity> getAll();
    List<EmergenciaEntity> getById(Long id);
    EmergenciaEntity save(EmergenciaEntity e);
    String updateNombreEmergencia(EmergenciaEntity e,Long id);
    void delete(Long id);


}