package Grupo6.services;


import Grupo6.entities.RankingEntity;
import Grupo6.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    public List<RankingEntity>  getAllRankings() {
        return rankingRepository.findAllRanking();
    }

    public RankingEntity getRankingById(Long id) {
        return rankingRepository.findRankingById(id);
    }

    public List<RankingEntity> getRankingsByIdVoluntario(Long idVoluntario) {
        return rankingRepository.findByIdVoluntario(idVoluntario);
    }
    public List<RankingEntity> getRankingsByIdTarea(Long idTarea) {
        return rankingRepository.findByIdTarea(idTarea);
    }

    public RankingEntity saveRanking(RankingEntity rankingEntity) {
        return rankingRepository.save(rankingEntity);
    }

    public RankingEntity updateRanking(RankingEntity rankingEntity) {
        return rankingRepository.updateById(rankingEntity);
    }

    public void deleteRankingById(Long id) {
        rankingRepository.deleteById(id);
    }


}
