package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.HabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HabilidadController {

    private final HabilidadRepository habilidadRepository;

    HabilidadController(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }
    // crear C
    @PostMapping("/habilidades/save")
    @ResponseBody
    public HabilidadEntity crearHabilidad(@RequestBody HabilidadEntity habilidad){
        HabilidadEntity habilidad1 = habilidadRepository.save(habilidad);
        return habilidad1;
    }
    // get R
    @GetMapping("/habilidades/getAll")
    @ResponseBody
    public List<HabilidadEntity> getAllHabilidades(){
        return habilidadRepository.getAll();
    }
    //get by
    @GetMapping("/habilidades/getById/{id}")
    @ResponseBody
    public List<HabilidadEntity> getHabilidadById(@PathVariable Long id){
        return habilidadRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/habilidades/update/{id}")
    @ResponseBody
    public String updateHabilidad(@RequestBody HabilidadEntity habilidad, @PathVariable Long id){
        String retorno = habilidadRepository.updateNombreHabilidad(habilidad,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/habilidades/delete/{id}")
    public void deleteHabilidad(@PathVariable Long id){
        habilidadRepository.delete(id);
    }

}
