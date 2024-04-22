package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.repositories.InstitucionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    public InstitucionEntity crearInstitucion( InstitucionEntity institucion){
        InstitucionEntity inst = institucionRepository.save(institucion);
        return inst;
    }
    // get R

    public List<InstitucionEntity> getAllInstituciones(){
        return institucionRepository.getAll();
    }
    //get by

    public List<InstitucionEntity> getInstitucionById( Long id){
        return institucionRepository.getById(id);
    }


    // actualizar U

    public String updateInstitucion( InstitucionEntity institucion, Long id){
        String retorno = institucionRepository.update(institucion,id);
        return retorno;
    }

    // borrar D

    public void deleteInstitucion(Long id){
        institucionRepository.delete(id);
    }

}
