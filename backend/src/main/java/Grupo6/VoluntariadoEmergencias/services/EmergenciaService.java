package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciaEntity;
import Grupo6.VoluntariadoEmergencias.repositories.EmergenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }
    // crear C

    public EmergenciaEntity crearEmergencia( EmergenciaEntity emergencia){
        EmergenciaEntity newEmergencia = emergenciaRepository.save(emergencia);
        return newEmergencia;
    }
    // get R

    public List<EmergenciaEntity> getAllEmergenciaes(){
        return emergenciaRepository.getAll();
    }
    //get by

    public List<EmergenciaEntity> getEmergenciaById(Long id){
        return emergenciaRepository.getById(id);
    }


    // actualizar U

    public String updateNombreEmergencia(EmergenciaEntity emergencia, Long id){
        String retorno = emergenciaRepository.updateNombreEmergencia(emergencia,id);
        return retorno;
    }

    // borrar D

    public void deleteEmergencia(Long id){
        emergenciaRepository.delete(id);
    }

}
