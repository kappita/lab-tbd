package Grupo6.repositories;

import Grupo6.entities.EmergenciaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergenciaRepository {

    List<EmergenciaEntity> findAll();
    EmergenciaEntity findByIdEmergencia(Long id);
    EmergenciaEntity save(EmergenciaEntity e);
    EmergenciaEntity update(EmergenciaEntity e);
    void delete(Long id);


}