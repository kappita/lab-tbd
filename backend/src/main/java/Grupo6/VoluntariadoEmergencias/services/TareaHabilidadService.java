package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.TareaHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.TareaHabilidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class TareaHabilidadService {
    private final TareaHabilidadRepository tareaHabilidadRepository;

    TareaHabilidadService(TareaHabilidadRepository tareaHabilidadRepository){
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }
    // crear C

    public TareaHabilidadEntity crearTareaHabilidad( TareaHabilidadEntity tareaHabilidad){
        TareaHabilidadEntity inst = tareaHabilidadRepository.save(tareaHabilidad);
        return inst;
    }
    // get R

    public List<TareaHabilidadEntity> getAllTareasHabilidades(){
        return tareaHabilidadRepository.getAll();
    }
    //get by

    public List<TareaHabilidadEntity> getTareaHabilidadById( Long id){
        return tareaHabilidadRepository.getById(id);
    }


    // actualizar U

    public String updateTareaAsignadaAHabilidad( TareaHabilidadEntity tareaHabilidad,  Long id){
        String retorno = tareaHabilidadRepository.updateTareaAsignada(tareaHabilidad,id);
        return retorno;
    }

    // borrar D

    public void deleteTareaHabilidad( Long id){
        tareaHabilidadRepository.delete(id);
    }

}
