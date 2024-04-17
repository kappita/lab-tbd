package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.repositories.InstitucionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstitucionService {

    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }
    // crear C
    @PostMapping("/save")
    @ResponseBody
    public InstitucionEntity crearInstitucion(@RequestBody InstitucionEntity institucion){
        InstitucionEntity inst = institucionRepository.save(institucion);
        return inst;
    }
    // get R
    /*
    public List<InstitucionEntity> getAllInstitucions(){
        return institucionRepository.getAll();
    }
    //get by

    public InstitucionEntity getInstitucionById(Long id){
        return institucionRepository.findInstitucionById(id);
    }


    // actualizar U

    public InstitucionEntity updateInstitucion(InstitucionEntity institucion){
        return institucionRepository.update(institucion);

    }

    // borrar D

    public Boolean deleteInstitucion(Long id) throws Exception {
        try{
            institucionRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    */
}
