package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.RankingEntity;
import Grupo6.VoluntariadoEmergencias.repositories.RankingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }
    // crear C

    public RankingEntity crearRanking( RankingEntity ranking){
        RankingEntity inst = rankingRepository.save(ranking);
        return inst;
    }
    // get R

    public List<RankingEntity> getAllRankinges(){
        return rankingRepository.getAll();
    }
    //get by

    public List<RankingEntity> getRankingById( Long id){
        return rankingRepository.getById(id);
    }


    public List<RankingEntity> getRankingByIdVoluntario( Long id){
        return rankingRepository.getByIdVoluntario(id);
    }


    public List<RankingEntity> getRankingByIdTarea( Long id){
        return rankingRepository.getByIdTarea(id);
    }


    // actualizar U

    public String updateRanking( RankingEntity ranking,  Long id){
        String retorno = rankingRepository.updatePosicionRanking(ranking,id);
        return retorno;
    }

    // borrar D

    public void deleteRanking( Long id){
        rankingRepository.delete(id);
    }
}
