package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.repositories.InstitucionRepository;

import Grupo6.VoluntariadoEmergencias.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstitucionController {

    @Autowired
    InstitucionService institucionService;
    // crear C
    @PostMapping("/instituciones/save")
    @ResponseBody
    public InstitucionEntity crearInstitucion(@RequestBody InstitucionEntity institucion){
        InstitucionEntity inst = institucionService.crearInstitucion(institucion);
        return inst;
    }
    // get R
    @GetMapping("/instituciones/getAll")
    @ResponseBody
    public List<InstitucionEntity> getAllInstituciones(){
        return institucionService.getAllInstituciones();
    }
    //get by
    @GetMapping("/instituciones/getById/{id}")
    @ResponseBody
    public List<InstitucionEntity> getInstitucionById(@PathVariable Long id){
        return institucionService.getInstitucionById(id);
    }


    // actualizar U
    @PutMapping("/instituciones/update/{id}")
    @ResponseBody
    public String updateInstitucion(@RequestBody InstitucionEntity institucion, @PathVariable Long id){
        String retorno = institucionService.updateInstitucion(institucion,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/instituciones/delete/{id}")
    public void deleteInstitucion(@PathVariable Long id){
        institucionService.deleteInstitucion(id);
    }

}
