package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;
import Grupo6.VoluntariadoEmergencias.repositories.TareaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    public TareaEntity crearTarea( TareaEntity tarea){
        TareaEntity tarea1 = tareaRepository.save(tarea);
        return tarea1;
    }
    // get R

    public List<TareaEntity> getAllTareas(){
        return tareaRepository.getAll();
    }
    //get by

    public List<TareaEntity> getTareaById( Long id){
        return tareaRepository.getById(id);
    }



    public String updateNombreTarea(TareaEntity tarea,  Long id){
        String retorno = tareaRepository.update(tarea,id);
        return retorno;
    }


    public void deleteTarea( Long id){
        tareaRepository.delete(id);
    }
}
