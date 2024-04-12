package Grupo6.repositories;

import Grupo6.entities.RankingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository {
    List<RankingEntity> findAllRanking();
    RankingEntity findRankingById(Long id);
    List<RankingEntity> findByIdVoluntario(Long idVoluntario);
    List<RankingEntity> findByIdTarea(Long idTarea);
    RankingEntity save(RankingEntity rankingEntity);
    RankingEntity updateById(RankingEntity rankingEntity);
    void deleteById(Long id);
}
