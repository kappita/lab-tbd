package Grupo6.repositories;

import Grupo6.entities.DisponibleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibleRepository {
    List<DisponibleEntity> getAll();
    DisponibleEntity findByIdDisponible(Long id);
    DisponibleEntity save(DisponibleEntity d);
    DisponibleEntity update(DisponibleEntity d);
    void delete(Long id);
}
