package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;
import Grupo6.VoluntariadoEmergencias.repositories.HabilidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }
    // crear C

    public HabilidadEntity crearHabilidad( HabilidadEntity habilidad){
        HabilidadEntity habilidad1 = habilidadRepository.save(habilidad);
        return habilidad1;
    }
    // get R

    public List<HabilidadEntity> getAllHabilidades(){
        return habilidadRepository.getAll();
    }
    //get by

    public List<HabilidadEntity> getHabilidadById(Long id){
        return habilidadRepository.getById(id);
    }



    public String updateNombreHabilidad( HabilidadEntity habilidad, Long id){
        String retorno = habilidadRepository.updateNombreHabilidad(habilidad,id);
        return retorno;
    }


    public void deleteHabilidad(Long id){
        habilidadRepository.delete(id);
    }

}
