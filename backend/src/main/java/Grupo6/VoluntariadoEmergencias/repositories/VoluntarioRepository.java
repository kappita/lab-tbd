package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VoluntarioRepository {

    List<VoluntarioEntity> getAll();
    List<VoluntarioEntity> getById(Long id);
    VoluntarioEntity save(VoluntarioEntity voluntario);
    VoluntarioEntity getByEmail(String email);
    String update(VoluntarioEntity voluntario,Long id);
    void delete(Long id);
}
