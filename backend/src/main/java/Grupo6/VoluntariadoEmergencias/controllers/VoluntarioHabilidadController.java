package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.services.VoluntarioHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioHabilidadController {

    @Autowired
    VoluntarioHabilidadService voluntarioHabilidadService;
    // crear C
    @PostMapping("/voluntarioHabilidad/save")
    @ResponseBody
    public VoluntarioHabilidadEntity crearVoluntarioHabilidad(@RequestBody VoluntarioHabilidadEntity voluntarioHabilidad){
        VoluntarioHabilidadEntity inst = voluntarioHabilidadService.crearVoluntarioHabilidad(voluntarioHabilidad);
        return inst;
    }
    // get R
    @GetMapping("/voluntarioHabilidad/getAll")
    @ResponseBody
    public List<VoluntarioHabilidadEntity> getAllVoluntarioHabilidades(){
        return voluntarioHabilidadService.getAllVoluntarioHabilidades();
    }
    //get by
    @GetMapping("/voluntarioHabilidad/getById/{id}")
    @ResponseBody
    public List<VoluntarioHabilidadEntity> getVoluntarioHabilidadById(@PathVariable Long id){
        return voluntarioHabilidadService.getVoluntarioHabilidadById(id);
    }


    // actualizar U
    @PutMapping("/voluntarioHabilidad/update/{id}")
    @ResponseBody
    public String updateVoluntarioHabilidad(@RequestBody VoluntarioHabilidadEntity voluntarioHabilidad, @PathVariable Long id){
        String retorno = voluntarioHabilidadService.updateVoluntarioHabilidad(voluntarioHabilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/voluntarioHabilidad/delete/{id}")
    public void deleteVoluntarioHabilidad(@PathVariable Long id){
        voluntarioHabilidadService.deleteVoluntarioHabilidad(id);
    }

}
