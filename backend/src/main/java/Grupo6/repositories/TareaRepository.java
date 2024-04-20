package Grupo6.repositories;

import Grupo6.entities.TareaEmergenciaEntity;
import Grupo6.entities.TareaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository {

    List<TareaEntity> findAll();
    TareaEntity findByIdTarea(Long id);
    List<TareaEmergenciaEntity> findEligibleTareasByVoluntaryEmail(String email);
    TareaEntity save(TareaEntity t);
    TareaEntity update(TareaEntity t);
    void delete(Long id);

}
