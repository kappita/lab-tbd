package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciaEntity;

import Grupo6.VoluntariadoEmergencias.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmergenciaController {

    @Autowired
    EmergenciaService emergenciaService;
    // crear C
    @PostMapping("/emergencias/save")
    @ResponseBody
    public EmergenciaEntity crearEmergencia(@RequestBody EmergenciaEntity emergencia){
        EmergenciaEntity newEmergencia = emergenciaService.crearEmergencia(emergencia);
        return newEmergencia;
    }
    // get R
    @GetMapping("/emergencias/getAll")
    @ResponseBody
    public List<EmergenciaEntity> getAllEmergenciaes(){
        return emergenciaService.getAllEmergenciaes();
    }
    //get by
    @GetMapping("/emergencias/getById/{id}")
    @ResponseBody
    public List<EmergenciaEntity> getEmergenciaById(@PathVariable Long id){
        return emergenciaService.getEmergenciaById(id);
    }


    // actualizar U
    @PutMapping("/emergencias/update/{id}")
    @ResponseBody
    public String updateNombreEmergencia(@RequestBody EmergenciaEntity emergencia, @PathVariable Long id){
        String retorno = emergenciaService.updateNombreEmergencia(emergencia,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/emergencias/delete/{id}")
    public void deleteEmergencia(@PathVariable Long id){
        emergenciaService.deleteEmergencia(id);
    }

}
