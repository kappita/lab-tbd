package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;

import java.util.List;

public interface HabilidadRepository {
    List<HabilidadEntity> getAll();
    List<HabilidadEntity> getById(Long id);
    HabilidadEntity save(HabilidadEntity habilidad);
    String updateNombreHabilidad(HabilidadEntity habilidad,Long id);
    void delete(Long id);
    List<HabilidadEntity> getByEmailVoluntario(String email);
}
