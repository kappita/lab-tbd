package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.TareaHabilidadEntity;

import Grupo6.VoluntariadoEmergencias.services.TareaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TareaHabilidadController {

   @Autowired
    TareaHabilidadService tareaHabilidadService;
    // crear C
    @PostMapping("/tareaHabilidad/save")
    @ResponseBody
    public TareaHabilidadEntity crearTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad){
        TareaHabilidadEntity inst = tareaHabilidadService.crearTareaHabilidad(tareaHabilidad);
        return inst;
    }
    // get R
    @GetMapping("/tareaHabilidad/getAll")
    @ResponseBody
    public List<TareaHabilidadEntity> getAllTareasHabilidades(){
        return tareaHabilidadService.getAllTareasHabilidades();
    }
    //get by
    @GetMapping("/tareaHabilidad/getById/{id}")
    @ResponseBody
    public List<TareaHabilidadEntity> getTareaHabilidadById(@PathVariable Long id){
        return tareaHabilidadService.getTareaHabilidadById(id);
    }


    // actualizar U
    @PutMapping("/tareaHabilidad/update/{id}")
    @ResponseBody
    public String updateTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad, @PathVariable Long id){
        String retorno = tareaHabilidadService.updateTareaAsignadaAHabilidad(tareaHabilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/tareaHabilidad/delete/{id}")
    public void deleteTareaHabilidad(@PathVariable Long id){
        tareaHabilidadService.deleteTareaHabilidad(id);
    }

}
