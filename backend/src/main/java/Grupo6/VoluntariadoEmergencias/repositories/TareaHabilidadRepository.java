package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.TareaHabilidadEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TareaHabilidadRepository {

    List<TareaHabilidadEntity> getAll();
    List<TareaHabilidadEntity> getById(Long id);
    TareaHabilidadEntity save(TareaHabilidadEntity th);
    String updateTareaAsignada(TareaHabilidadEntity th,Long id);
    void delete(Long id);
}
