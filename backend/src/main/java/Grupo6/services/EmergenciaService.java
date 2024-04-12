package Grupo6.services;

import Grupo6.entities.EmergenciaEntity;
import Grupo6.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public List<EmergenciaEntity> getEmergencia(){ return (List<EmergenciaEntity>) emergenciaRepository.findAll();}

    public EmergenciaEntity saveEmergencia (EmergenciaEntity emergencia){ return emergenciaRepository.save(emergencia);}

    public EmergenciaEntity getEmergenciaByIdEmergencia (Long id){ return emergenciaRepository.findByIdEmergencia(id);}

    public EmergenciaEntity updateEmergencia (EmergenciaEntity emergencia){ return emergenciaRepository.update(emergencia);}

    public boolean deleteEmergencia(Long id) throws Exception {
        try{
            emergenciaRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}