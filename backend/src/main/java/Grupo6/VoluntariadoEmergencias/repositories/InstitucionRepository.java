package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InstitucionRepository {
    //List<InstitucionEntity> getAll();
   // InstitucionEntity findInstitucionById(Long id);
    InstitucionEntity save(InstitucionEntity d);
    //InstitucionEntity update(InstitucionEntity d);
    //void delete(Long id);
}
