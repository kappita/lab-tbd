package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.TareaHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.TareaHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TareaHabilidadController {

    private final TareaHabilidadRepository tareaHabilidadRepository;

    TareaHabilidadController(TareaHabilidadRepository tareaHabilidadRepository){
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }
    // crear C
    @PostMapping("/tareaHabilidad/save")
    @ResponseBody
    public TareaHabilidadEntity crearTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad){
        TareaHabilidadEntity inst = tareaHabilidadRepository.save(tareaHabilidad);
        return inst;
    }
    // get R
    @GetMapping("/tareaHabilidad/getAll")
    @ResponseBody
    public List<TareaHabilidadEntity> getAllTareasHabilidades(){
        return tareaHabilidadRepository.getAll();
    }
    //get by
    @GetMapping("/tareaHabilidad/getById/{id}")
    @ResponseBody
    public List<TareaHabilidadEntity> getTareaHabilidadById(@PathVariable Long id){
        return tareaHabilidadRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/tareaHabilidad/update/{id}")
    @ResponseBody
    public String updateTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad, @PathVariable Long id){
        String retorno = tareaHabilidadRepository.updateTareaAsignada(tareaHabilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/tareaHabilidad/delete/{id}")
    public void deleteTareaHabilidad(@PathVariable Long id){
        tareaHabilidadRepository.delete(id);
    }

}
