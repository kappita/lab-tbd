package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;
import Grupo6.VoluntariadoEmergencias.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TareaController {

    private final TareaRepository tareaRepository;

    TareaController(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }
    // crear C
    @PostMapping("/tareas/save")
    @ResponseBody
    public TareaEntity crearTarea(@RequestBody TareaEntity tarea){
        TareaEntity tarea1 = tareaRepository.save(tarea);
        return tarea1;
    }
    // get R
    @GetMapping("/tareas/getAll")
    @ResponseBody
    public List<TareaEntity> getAllTareas(){
        return tareaRepository.getAll();
    }
    //get by
    @GetMapping("/tareas/getById/{id}")
    @ResponseBody
    public List<TareaEntity> getTareaById(@PathVariable Long id){
        return tareaRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/tareas/update/{id}")
    @ResponseBody
    public String updateTarea(@RequestBody TareaEntity tarea, @PathVariable Long id){
        String retorno = tareaRepository.update(tarea,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/tareas/delete/{id}")
    public void deleteTarea(@PathVariable Long id){
        tareaRepository.delete(id);
    }

}
