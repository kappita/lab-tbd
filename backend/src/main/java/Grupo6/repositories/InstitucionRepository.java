package Grupo6.repositories;

import Grupo6.entities.InstitucionEntity;
import Grupo6.entities.InstitucionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitucionRepository {
    List<InstitucionEntity> getAll();
    InstitucionEntity findInstitucionById(Long id);
    InstitucionEntity save(InstitucionEntity d);
    InstitucionEntity update(InstitucionEntity d);
    void delete(Long id);
}
