package Grupo6.services;


import Grupo6.entities.DisponibleEntity;
import Grupo6.repositories.DisponibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class DisponibleService {
    @Autowired
    private DisponibleRepository disponibleRepository;


    // crear C

    public DisponibleEntity createDisponible( DisponibleEntity disponible){
        DisponibleEntity disponible1 = disponibleRepository.save(disponible);
        return disponible1;
    }

    // get R

    public List<DisponibleEntity> getAllDisponibles(){
        return disponibleRepository.getAll();
    }
    //get by

    public DisponibleEntity getDisponibleById(Long id){
        return disponibleRepository.findByIdDisponible(id);
    }


    // actualizar U

    public DisponibleEntity updateDisponible(DisponibleEntity disponible){
        return disponibleRepository.update(disponible);
    }

    // borrar D

    public Boolean deleteDisponible( Long id) throws Exception {
        try{
            disponibleRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
