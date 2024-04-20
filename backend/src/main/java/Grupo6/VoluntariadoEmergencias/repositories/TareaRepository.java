package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TareaRepository {

    List<TareaEntity> getAll();
    List<TareaEntity> getById(Long id);
    TareaEntity save(TareaEntity t);
    String update(TareaEntity t,Long id);
    void delete(Long id);

}
