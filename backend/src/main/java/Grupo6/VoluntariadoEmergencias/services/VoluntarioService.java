package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import Grupo6.VoluntariadoEmergencias.repositories.HabilidadRepository;
import Grupo6.VoluntariadoEmergencias.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    public VoluntarioEntity crearVoluntario( VoluntarioEntity voluntario){
        VoluntarioEntity voluntario1 = voluntarioRepository.save(voluntario);
        return voluntario1;
    }
    // get R

    public List<VoluntarioEntity> getAllVoluntarios(){
        return voluntarioRepository.getAll();
    }
    //get by

    public List<VoluntarioEntity> getVoluntarioById(Long id){
        return voluntarioRepository.getById(id);
    }


    // actualizar U

    public String updateVoluntario(VoluntarioEntity voluntario, Long id){
        String retorno = voluntarioRepository.update(voluntario,id);
        return retorno;
    }

    // borrar D

    public void deleteVoluntario(Long id){
        voluntarioRepository.delete(id);
    }

    @Autowired
    private HabilidadRepository habilidadRepository;
    public List<HabilidadEntity> getAllHabilidades() {
        return habilidadRepository.findAll();
    }


}
