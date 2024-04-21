package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.Responses.TareaConHabilidades;
import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;

import Grupo6.VoluntariadoEmergencias.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TareaController {

    @Autowired
    TareaService tareaService;
    // crear C
    @PostMapping("/tareas/save")
    @ResponseBody
    public TareaEntity crearTarea(@RequestBody TareaEntity tarea){
        TareaEntity tarea1 = tareaService.crearTarea(tarea);
        return tarea1;
    }
    // get R
    @GetMapping("/tareas/getAll")
    @ResponseBody
    public List<TareaEntity> getAllTareas(){
        return tareaService.getAllTareas();
    }
    //get by
    @GetMapping("/tareas/getById/{id}")
    @ResponseBody
    public List<TareaEntity> getTareaById(@PathVariable Long id){
        return tareaService.getTareaById(id);
    }


    // actualizar U
    @PutMapping("/tareas/update/{id}")
    @ResponseBody
    public String updateNombreTarea(@RequestBody TareaEntity tarea, @PathVariable Long id){
        String retorno = tareaService.updateNombreTarea(tarea,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/tareas/delete/{id}")
    public void deleteTarea(@PathVariable Long id){
        tareaService.deleteTarea(id);
    }

    @GetMapping("tareas/postulables/{email}")
    public ResponseEntity<List<TareaConHabilidades>> getEligibleTareasByVoluntaryEmail(@PathVariable String email) {
        List<TareaConHabilidades> tareas = tareaService.findEligibleTareasByVoluntaryEmail(email);
        return ResponseEntity.ok(tareas);

    }
}
