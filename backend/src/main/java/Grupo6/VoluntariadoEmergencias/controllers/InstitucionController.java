package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.repositories.InstitucionRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class InstitucionController {

    private final InstitucionRepository institucionRepository;

    InstitucionController(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }
    // crear C
    @PostMapping("/instituciones/save")
    @ResponseBody
    public InstitucionEntity crearInstitucion(@RequestBody InstitucionEntity institucion){
        InstitucionEntity inst = institucionRepository.save(institucion);
        return inst;
    }
    // get R
    @GetMapping("/instituciones/getAll")
    @ResponseBody
    public List<InstitucionEntity> getAllInstituciones(){
        return institucionRepository.getAll();
    }
    //get by
    @GetMapping("/instituciones/getById/{id}")
    @ResponseBody
    public List<InstitucionEntity> getInstitucionById(@PathVariable Long id){
        return institucionRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/instituciones/update/{id}")
    @ResponseBody
    public String updateInstitucion(@RequestBody InstitucionEntity institucion, @PathVariable Long id){
        String retorno = institucionRepository.update(institucion,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/instituciones/delete/{id}")
    public void deleteInstitucion(@PathVariable Long id){
        institucionRepository.delete(id);
    }

}
