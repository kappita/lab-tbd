package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;
import Grupo6.VoluntariadoEmergencias.repositories.DisponibleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DisponibleService {

    private final DisponibleRepository disponibleRepository;

    DisponibleService(DisponibleRepository disponibleRepository){
        this.disponibleRepository = disponibleRepository;
    }

    public DisponibleEntity crearDisponible( DisponibleEntity disponible){
        DisponibleEntity inst = disponibleRepository.save(disponible);
        return inst;
    }
    // get R

    public List<DisponibleEntity> getAllDisponiblees(){
        return disponibleRepository.getAll();
    }
    //get by

    public List<DisponibleEntity> getDisponibleById(Long id){
        return disponibleRepository.getById(id);
    }


    // actualizar U

    public String updateIdEmergenciaAsignada( DisponibleEntity disponible, Long id){
        String retorno = disponibleRepository.updateIdEmergenciaAsignada(disponible,id);
        return retorno;
    }


    public void deleteDisponible(Long id){
        disponibleRepository.delete(id);
    }

}
