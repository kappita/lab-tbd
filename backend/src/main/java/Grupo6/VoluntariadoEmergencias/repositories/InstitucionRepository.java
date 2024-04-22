package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InstitucionRepository {
    List<InstitucionEntity> getAll();
    List<InstitucionEntity> getById(Long id);
    InstitucionEntity save(InstitucionEntity d);

    String update(InstitucionEntity d,Long id);
    VoluntarioEntity getByEmail(String email);
    void delete(Long id);
}
