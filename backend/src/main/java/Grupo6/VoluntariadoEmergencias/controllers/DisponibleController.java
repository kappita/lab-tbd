package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;
import Grupo6.VoluntariadoEmergencias.repositories.DisponibleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DisponibleController {

    private final DisponibleRepository disponibleRepository;

    DisponibleController(DisponibleRepository disponibleRepository){
        this.disponibleRepository = disponibleRepository;
    }
    // crear C
    @PostMapping("/disponibles/save")
    @ResponseBody
    public DisponibleEntity crearDisponible(@RequestBody DisponibleEntity disponible){
        DisponibleEntity inst = disponibleRepository.save(disponible);
        return inst;
    }
    // get R
    @GetMapping("/disponibles/getAll")
    @ResponseBody
    public List<DisponibleEntity> getAllDisponiblees(){
        return disponibleRepository.getAll();
    }
    //get by
    @GetMapping("/disponibles/getById/{id}")
    @ResponseBody
    public List<DisponibleEntity> getDisponibleById(@PathVariable Long id){
        return disponibleRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/disponibles/update/{id}")
    @ResponseBody
    public String updateIdEmergenciaAsignada(@RequestBody DisponibleEntity disponible, @PathVariable Long id){
        String retorno = disponibleRepository.updateIdEmergenciaAsignada(disponible,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/disponibles/delete/{id}")
    public void deleteDisponible(@PathVariable Long id){
        disponibleRepository.delete(id);
    }

}
