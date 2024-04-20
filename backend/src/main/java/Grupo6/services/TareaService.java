package Grupo6.services;

import Grupo6.entities.TareaEmergenciaEntity;
import Grupo6.entities.TareaEntity;
import Grupo6.entities.TareaHabilidadEntity;
import Grupo6.repositories.TareaRepository;
import Grupo6.responses.TareaConHabilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<TareaEntity> getTareas(){
        return tareaRepository.findAll();
    }

    public TareaEntity saveTarea(TareaEntity tarea){
        return tareaRepository.save(tarea);
    }

    public TareaEntity getTareaByIdTarea(Long id){
        return tareaRepository.findByIdTarea(id);
    }

    public TareaEntity updateTarea(TareaEntity tarea) {
        return tareaRepository.update(tarea);
    }

    public boolean deleteTarea(Long id) throws Exception {
        try{
            tareaRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
