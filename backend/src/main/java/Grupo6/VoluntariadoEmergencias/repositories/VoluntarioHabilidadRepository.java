package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioHabilidadEntity;

import java.util.List;


public interface VoluntarioHabilidadRepository {
    List<VoluntarioHabilidadEntity> getAll();
    List<VoluntarioHabilidadEntity> getById(Long id);
    VoluntarioHabilidadEntity save(VoluntarioHabilidadEntity d);
    String updateVoluntarioAsignado(VoluntarioHabilidadEntity d,Long id);
    void delete(Long id);
}
