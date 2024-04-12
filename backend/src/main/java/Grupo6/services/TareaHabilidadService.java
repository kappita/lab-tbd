package Grupo6.services;

import Grupo6.entities.TareaHabilidadEntity;
import Grupo6.repositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Service
public class TareaHabilidadService {
    @Autowired
    private TareaHabilidadRepository tareaHabilidadRepository;

    public List<TareaHabilidadEntity> getTareasHabilidad(){
        return (List<TareaHabilidadEntity>) tareaHabilidadRepository.findAll();
    }

    public TareaHabilidadEntity saveTareaHabilidad(TareaHabilidadEntity tareaHabilidad){
        return tareaHabilidadRepository.save(tareaHabilidad);
    }

    public TareaHabilidadEntity getTareaHabilidadByIdTareaHabilidad(Long id){
        return tareaHabilidadRepository.findByIdTareaHabilidad(id);
    }

    public TareaHabilidadEntity updateTareaHabilidad(TareaHabilidadEntity tareaHabilidad) {
        return tareaHabilidadRepository.update(tareaHabilidad);
    }

    public boolean deleteTareaHabilidad(Long id) throws Exception {
        try{
            tareaHabilidadRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
