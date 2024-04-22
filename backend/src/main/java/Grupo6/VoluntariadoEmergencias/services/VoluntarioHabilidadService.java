package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.HabilidadRepository;
import Grupo6.VoluntariadoEmergencias.repositories.VoluntarioHabilidadRepository;
import Grupo6.VoluntariadoEmergencias.repositories.VoluntarioHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioHabilidadService {

    private final VoluntarioHabilidadRepository institucionRepository;

    VoluntarioHabilidadService(VoluntarioHabilidadRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    public VoluntarioHabilidadEntity crearVoluntarioHabilidad(VoluntarioHabilidadEntity institucion){
        VoluntarioHabilidadEntity inst = institucionRepository.save(institucion);
        return inst;
    }
    // get R

    public List<VoluntarioHabilidadEntity> getAllVoluntarioHabilidades(){
        return institucionRepository.getAll();
    }
    //get by

    public List<VoluntarioHabilidadEntity> getVoluntarioHabilidadById( Long id){
        return institucionRepository.getById(id);
    }


    // actualizar U

    public String updateVoluntarioHabilidad( VoluntarioHabilidadEntity institucion, Long id){
        String retorno = institucionRepository.updateVoluntarioAsignado(institucion,id);
        return retorno;
    }

    // borrar D

    public void deleteVoluntarioHabilidad(Long id){
        institucionRepository.delete(id);
    }


}
