package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.Forms.LoginForm;
import Grupo6.VoluntariadoEmergencias.Responses.Login;
import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;

import Grupo6.VoluntariadoEmergencias.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituciones")
public class InstitucionController {

    @Autowired
    InstitucionService institucionService;
    // crear C
    @PostMapping("/save")
    @ResponseBody
    public InstitucionEntity crearInstitucion(@RequestBody InstitucionEntity institucion){
        InstitucionEntity inst = institucionService.crearInstitucion(institucion);
        return inst;
    }
    // get R
    @GetMapping("/getAll")
    @ResponseBody
    public List<InstitucionEntity> getAllInstituciones(){
        return institucionService.getAllInstituciones();
    }
    //get by
    @GetMapping("/getById/{id}")
    @ResponseBody
    public List<InstitucionEntity> getInstitucionById(@PathVariable Long id){
        return institucionService.getInstitucionById(id);
    }


    // actualizar U
    @PutMapping("/update/{id}")
    @ResponseBody
    public String updateInstitucion(@RequestBody InstitucionEntity institucion, @PathVariable Long id){
        String retorno = institucionService.updateInstitucion(institucion,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/delete/{id}")
    public void deleteInstitucion(@PathVariable Long id){
        institucionService.deleteInstitucion(id);
    }

    @PostMapping("/login")
    public Login login(@RequestBody LoginForm form){
        return institucionService.login(form);
    }

}
