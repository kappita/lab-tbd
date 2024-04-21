package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;

import Grupo6.VoluntariadoEmergencias.services.DisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DisponibleController {

   @Autowired
    DisponibleService disponibleService;
    // crear C
    @PostMapping("/disponibles/save")
    @ResponseBody
    public DisponibleEntity crearDisponible(@RequestBody DisponibleEntity disponible){
        DisponibleEntity inst = disponibleService.crearDisponible(disponible);
        return inst;
    }
    // get R
    @GetMapping("/disponibles/getAll")
    @ResponseBody
    public List<DisponibleEntity> getAllDisponiblees(){
        return disponibleService.getAllDisponiblees();
    }
    //get by
    @GetMapping("/disponibles/getById/{id}")
    @ResponseBody
    public List<DisponibleEntity> getDisponibleById(@PathVariable Long id){
        return disponibleService.getDisponibleById(id);
    }


    // actualizar U
    @PutMapping("/disponibles/update/{id}")
    @ResponseBody
    public String updateIdEmergenciaAsignada(@RequestBody DisponibleEntity disponible, @PathVariable Long id){
        String retorno = disponibleService.updateIdEmergenciaAsignada(disponible,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/disponibles/delete/{id}")
    public void deleteDisponible(@PathVariable Long id){
        disponibleService.deleteDisponible(id);
    }

}
