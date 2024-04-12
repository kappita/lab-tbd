package Grupo6.repositories;

import Grupo6.entities.HabilidadEntity;

import java.util.List;

public interface HabilidadRepository {
    List<HabilidadEntity> findAllHabilidades();
    HabilidadEntity findHabilidadById(Long id);
    HabilidadEntity save(HabilidadEntity habilidad);
    HabilidadEntity updateById(HabilidadEntity habilidad);
    void deleteById(Long id);
}
