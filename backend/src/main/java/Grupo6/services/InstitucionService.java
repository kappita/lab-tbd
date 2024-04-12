package Grupo6.services;

import Grupo6.entities.InstitucionEntity;
import Grupo6.repositories.InstitucionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class InstitucionService {

    @Autowired
    InstitucionRepository institucionRepository;

    // crear C

    public InstitucionEntity crearInstitucion( InstitucionEntity institucion){
        InstitucionEntity inst = institucionRepository.save(institucion);
        return inst;
    }

    // get R

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

}
