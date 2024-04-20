package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.RankingEntity;
import Grupo6.VoluntariadoEmergencias.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RankingController {

    private final RankingRepository rankingRepository;

    RankingController(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }
    // crear C
    @PostMapping("/ranking/save")
    @ResponseBody
    public RankingEntity crearRanking(@RequestBody RankingEntity ranking){
        RankingEntity inst = rankingRepository.save(ranking);
        return inst;
    }
    // get R
    @GetMapping("/ranking/getAll")
    @ResponseBody
    public List<RankingEntity> getAllRankinges(){
        return rankingRepository.getAll();
    }
    //get by
    @GetMapping("/ranking/getById/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingById(@PathVariable Long id){
        return rankingRepository.getById(id);
    }

    @GetMapping("/ranking/getByIdVoluntario/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingByIdVoluntario(@PathVariable Long id){
        return rankingRepository.getByIdVoluntario(id);
    }

    @GetMapping("/ranking/getByIdTarea/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingByIdTarea(@PathVariable Long id){
        return rankingRepository.getByIdTarea(id);
    }


    // actualizar U
    @PutMapping("/ranking/updatePosicionRanking/{id}")
    @ResponseBody
    public String updateRanking(@RequestBody RankingEntity ranking, @PathVariable Long id){
        String retorno = rankingRepository.updatePosicionRanking(ranking,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/ranking/delete/{id}")
    public void deleteRanking(@PathVariable Long id){
        rankingRepository.delete(id);
    }

}
