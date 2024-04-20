package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciaEntity;
import Grupo6.VoluntariadoEmergencias.repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmergenciaController {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaController(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }
    // crear C
    @PostMapping("/emergencias/save")
    @ResponseBody
    public EmergenciaEntity crearEmergencia(@RequestBody EmergenciaEntity emergencia){
        EmergenciaEntity newEmergencia = emergenciaRepository.save(emergencia);
        return newEmergencia;
    }
    // get R
    @GetMapping("/emergencias/getAll")
    @ResponseBody
    public List<EmergenciaEntity> getAllEmergenciaes(){
        return emergenciaRepository.getAll();
    }
    //get by
    @GetMapping("/emergencias/getById/{id}")
    @ResponseBody
    public List<EmergenciaEntity> getEmergenciaById(@PathVariable Long id){
        return emergenciaRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/emergencias/update/{id}")
    @ResponseBody
    public String updateNombreEmergencia(@RequestBody EmergenciaEntity emergencia, @PathVariable Long id){
        String retorno = emergenciaRepository.updateNombreEmergencia(emergencia,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/emergencias/delete/{id}")
    public void deleteEmergencia(@PathVariable Long id){
        emergenciaRepository.delete(id);
    }

}
