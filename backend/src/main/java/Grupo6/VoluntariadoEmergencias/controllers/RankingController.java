package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.RankingEntity;

import Grupo6.VoluntariadoEmergencias.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RankingController {

   @Autowired
    RankingService rankingService;

    @PostMapping("/ranking/save")
    @ResponseBody
    public RankingEntity crearRanking(@RequestBody RankingEntity ranking){
        RankingEntity inst = rankingService.crearRanking(ranking);
        return inst;
    }
    // get R
    @GetMapping("/ranking/getAll")
    @ResponseBody
    public List<RankingEntity> getAllRankinges(){
        return rankingService.getAllRankinges();
    }
    //get by
    @GetMapping("/ranking/getById/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingById(@PathVariable Long id){
        return rankingService.getRankingById(id);
    }

    @GetMapping("/ranking/getByIdVoluntario/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingByIdVoluntario(@PathVariable Long id){
        return rankingService.getRankingByIdVoluntario(id);
    }

    @GetMapping("/ranking/getByIdTarea/{id}")
    @ResponseBody
    public List<RankingEntity> getRankingByIdTarea(@PathVariable Long id){
        return rankingService.getRankingByIdTarea(id);
    }


    // actualizar U
    @PutMapping("/ranking/updatePosicionRanking/{id}")
    @ResponseBody
    public String updateRanking(@RequestBody RankingEntity ranking, @PathVariable Long id){
        String retorno = rankingService.updateRanking(ranking,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/ranking/delete/{id}")
    public void deleteRanking(@PathVariable Long id){
        rankingService.deleteRanking(id);
    }

}
