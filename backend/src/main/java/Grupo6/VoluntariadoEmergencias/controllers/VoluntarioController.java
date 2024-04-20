package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import Grupo6.VoluntariadoEmergencias.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioController {

    private final VoluntarioRepository voluntarioRepository;

    VoluntarioController(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }
    // crear C
    @PostMapping("/voluntarios/save")
    @ResponseBody
    public VoluntarioEntity crearVoluntario(@RequestBody VoluntarioEntity voluntario){
        VoluntarioEntity voluntario1 = voluntarioRepository.save(voluntario);
        return voluntario1;
    }
    // get R
    @GetMapping("/voluntarios/getAll")
    @ResponseBody
    public List<VoluntarioEntity> getAllVoluntarios(){
        return voluntarioRepository.getAll();
    }
    //get by
    @GetMapping("/voluntarios/getById/{id}")
    @ResponseBody
    public List<VoluntarioEntity> getVoluntarioById(@PathVariable Long id){
        return voluntarioRepository.getById(id);
    }


    // actualizar U
    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public String updateVoluntario(@RequestBody VoluntarioEntity voluntario, @PathVariable Long id){
        String retorno = voluntarioRepository.update(voluntario,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/voluntarios/delete/{id}")
    public void deleteVoluntario(@PathVariable Long id){
        voluntarioRepository.delete(id);
    }

}
