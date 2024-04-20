package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DisponibleRepository {
    List<DisponibleEntity> getAll();
    List<DisponibleEntity> getById(Long id);
    DisponibleEntity save(DisponibleEntity d);
    String updateIdEmergenciaAsignada(DisponibleEntity d,Long id);
    void delete(Long id);
}
