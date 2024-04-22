package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.EmeHabilidadEntity;

import java.util.List;


public interface EmeHabilidadRepository {
    List<EmeHabilidadEntity> getAll();
   List<EmeHabilidadEntity> getById(Long id);
    EmeHabilidadEntity save(EmeHabilidadEntity d);

    String updateHabilidadAsignada(EmeHabilidadEntity d,Long id);

    void delete(Long id);
}
