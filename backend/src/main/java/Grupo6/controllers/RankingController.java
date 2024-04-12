package Grupo6.controllers;


import Grupo6.entities.RankingEntity;
import Grupo6.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@CrossOrigin("*")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    public ResponseEntity<List<RankingEntity>> getAllRankings() {
        List<RankingEntity> rankings = rankingService.getAllRankings();
        return ResponseEntity.ok(rankings);
    }

    public ResponseEntity<RankingEntity> getRankingById(Long id) {
        RankingEntity ranking = rankingService.getRankingById(id);
        return ResponseEntity.ok(ranking);
    }

    public ResponseEntity<RankingEntity> saveRanking(RankingEntity ranking) {
        RankingEntity response = rankingService.saveRanking(ranking);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<RankingEntity> updateRankingById(RankingEntity ranking) {
        RankingEntity response = rankingService.updateRanking(ranking);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<RankingEntity> deleteRankingById(Long id) {
        rankingService.deleteRankingById(id);
        return ResponseEntity.ok().build();
    }
}
