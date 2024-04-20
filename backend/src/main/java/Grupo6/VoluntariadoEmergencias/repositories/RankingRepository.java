package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.RankingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RankingRepository {
    List<RankingEntity> getAll();
    List<RankingEntity> getById(Long id);
    List<RankingEntity> getByIdVoluntario(Long idVoluntario);
    List<RankingEntity> getByIdTarea(Long idTarea);
    RankingEntity save(RankingEntity rankingEntity);
    String updatePosicionRanking(RankingEntity rankingEntity,Long id);
    void delete(Long id);
}
