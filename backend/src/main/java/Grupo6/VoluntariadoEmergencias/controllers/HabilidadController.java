package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;

import Grupo6.VoluntariadoEmergencias.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HabilidadController {

   @Autowired
    HabilidadService habilidadService;

    @PostMapping("/habilidades/save")
    @ResponseBody
    public HabilidadEntity crearHabilidad(@RequestBody HabilidadEntity habilidad){
        HabilidadEntity habilidad1 = habilidadService.crearHabilidad(habilidad);
        return habilidad1;
    }
    // get R
    @GetMapping("/habilidades/getAll")
    @ResponseBody
    public List<HabilidadEntity> getAllHabilidades(){
        return habilidadService.getAllHabilidades();
    }
    //get by
    @GetMapping("/habilidades/getById/{id}")
    @ResponseBody
    public List<HabilidadEntity> getHabilidadById(@PathVariable Long id){
        return habilidadService.getHabilidadById(id);
    }


    // actualizar U
    @PutMapping("/habilidades/update/{id}")
    @ResponseBody
    public String updateHabilidad(@RequestBody HabilidadEntity habilidad, @PathVariable Long id){
        String retorno = habilidadService.updateNombreHabilidad(habilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/habilidades/delete/{id}")
    public void deleteHabilidad(@PathVariable Long id){
        habilidadService.deleteHabilidad(id);
    }

}
