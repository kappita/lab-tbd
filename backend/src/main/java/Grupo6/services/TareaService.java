package Grupo6.services;

import Grupo6.entities.TareaEmergenciaEntity;
import Grupo6.entities.TareaEntity;
import Grupo6.entities.TareaHabilidadEntity;
import Grupo6.repositories.TareaRepository;
import Grupo6.responses.TareaConHabilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    public List<TareaConHabilidades> findEligibleTareasByVoluntaryEmail(String email) {
        // Se obtienen las tareas con emergencia del voluntario
        List<TareaEmergenciaEntity> tareasEmergencia = tareaRepository.findEligibleTareasByVoluntaryEmail(email);

        List<TareaConHabilidades> tareasConHabilidades = new ArrayList<>();

        // Se unen las habilidades de cada tarea a su tarea
        // y se guardan en una lista
        Long idTarea = tareasEmergencia.getFirst().getIdTarea();
        TareaConHabilidades nuevaTarea = new TareaConHabilidades(tareasEmergencia.getFirst());
        for (TareaEmergenciaEntity tarea : tareasEmergencia) {
            if (!idTarea.equals(tarea.getIdTarea())) {
                tareasConHabilidades.add(nuevaTarea);
                nuevaTarea = new TareaConHabilidades(tarea);
            }
            nuevaTarea.appendHabilidad(tarea.getHabilidad());
        }
        return tareasConHabilidades;
    }
}
