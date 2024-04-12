package Grupo6.repositories;

import Grupo6.entities.TareaHabilidadEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaHabilidadRepository {

    List<TareaHabilidadEntity> findAll();
    TareaHabilidadEntity findByIdTareaHabilidad(Long id);
    TareaHabilidadEntity save(TareaHabilidadEntity th);
    TareaHabilidadEntity update(TareaHabilidadEntity th);
    void delete(Long id);
}
