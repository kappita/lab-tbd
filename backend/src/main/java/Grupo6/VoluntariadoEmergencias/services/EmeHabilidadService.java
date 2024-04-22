package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.EmeHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.EmeHabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmeHabilidadService {
    private final EmeHabilidadRepository emeHabilidadRepository;

    EmeHabilidadService(EmeHabilidadRepository emeHabilidadRepository){
        this.emeHabilidadRepository = emeHabilidadRepository;
    }

    public EmeHabilidadEntity crearEmeHabilidad( EmeHabilidadEntity emeHabilidad){
        EmeHabilidadEntity inst = emeHabilidadRepository.save(emeHabilidad);
        return inst;
    }
    // get R

    public List<EmeHabilidadEntity> getAllEmeHabilidades(){
        return emeHabilidadRepository.getAll();
    }
    //get by

    public List<EmeHabilidadEntity> getEmeHabilidadById( Long id){
        return emeHabilidadRepository.getById(id);
    }


    // actualizar U

    public String updateEmeHabilidad( EmeHabilidadEntity emeHabilidad, Long id){
        String retorno = emeHabilidadRepository.updateHabilidadAsignada(emeHabilidad,id);
        return retorno;
    }

    // borrar D

    public void deleteEmeHabilidad(Long id){
        emeHabilidadRepository.delete(id);
    }

}
