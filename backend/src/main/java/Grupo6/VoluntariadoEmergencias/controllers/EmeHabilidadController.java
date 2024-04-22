package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.EmeHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.services.EmeHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmeHabilidadController {

    @Autowired
    EmeHabilidadService emeHabilidadService;
    // crear C
    @PostMapping("/emeHabilidades/save")
    @ResponseBody
    public EmeHabilidadEntity crearEmeHabilidad(@RequestBody EmeHabilidadEntity emeHabilidad){
        EmeHabilidadEntity inst = emeHabilidadService.crearEmeHabilidad(emeHabilidad);
        return inst;
    }
    // get R
    @GetMapping("/emeHabilidades/getAll")
    @ResponseBody
    public List<EmeHabilidadEntity> getAllEmeHabilidades(){
        return emeHabilidadService.getAllEmeHabilidades();
    }
    //get by
    @GetMapping("/emeHabilidades/getById/{id}")
    @ResponseBody
    public List<EmeHabilidadEntity> getEmeHabilidadById(@PathVariable Long id){
        return emeHabilidadService.getEmeHabilidadById(id);
    }


    // actualizar U
    @PutMapping("/emeHabilidades/update/{id}")
    @ResponseBody
    public String updateEmeHabilidad(@RequestBody EmeHabilidadEntity emeHabilidad, @PathVariable Long id){
        String retorno = emeHabilidadService.updateEmeHabilidad(emeHabilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/emeHabilidades/delete/{id}")
    public void deleteEmeHabilidad(@PathVariable Long id){
        emeHabilidadService.deleteEmeHabilidad(id);
    }

}
