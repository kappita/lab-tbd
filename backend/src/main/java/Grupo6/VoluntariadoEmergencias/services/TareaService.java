package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.Responses.TareaConHabilidades;
import Grupo6.VoluntariadoEmergencias.entities.TareaEmergenciaEntity;
import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;
import Grupo6.VoluntariadoEmergencias.repositories.TareaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    public List<TareaConHabilidades> findEligibleTareasByVoluntaryEmail(String email) {
        // Se obtienen las tareas con emergencia del voluntario
        List<TareaEmergenciaEntity> tareasEmergencia = tareaRepository.findEligibleTareasByVoluntaryEmail(email);

        List<TareaConHabilidades> tareasConHabilidades = new ArrayList<>();

        // Se unen las habilidades de cada tarea a su tarea
        // y se guardan en una lista
        Long idTarea = tareasEmergencia.get(0).getIdTarea();
        TareaConHabilidades nuevaTarea = new TareaConHabilidades(tareasEmergencia.get(0));
        for (TareaEmergenciaEntity tarea : tareasEmergencia) {
            if (!idTarea.equals(tarea.getIdTarea())) {
                tareasConHabilidades.add(nuevaTarea);
                idTarea = tarea.getIdTarea();
                nuevaTarea = new TareaConHabilidades(tarea);
            }
            nuevaTarea.appendHabilidad(tarea.getNombre_habilidad());
        }
        tareasConHabilidades.add(nuevaTarea);
        return tareasConHabilidades;
    }
}
