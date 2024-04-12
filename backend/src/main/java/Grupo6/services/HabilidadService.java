package Grupo6.services;

import Grupo6.entities.HabilidadEntity;
import Grupo6.repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    public List<HabilidadEntity> findAllHabilidades() {
        return habilidadRepository.findAllHabilidades();
    }

    public HabilidadEntity findHabilidadById(Long id) {
        return habilidadRepository.findHabilidadById(id);
    }

    public HabilidadEntity saveHabilidad(HabilidadEntity habilidad) {
        return habilidadRepository.save(habilidad);
    }

    public HabilidadEntity updateHabilidad(HabilidadEntity habilidad) {
        return habilidadRepository.updateById(habilidad);
    }

    public void deleteById(Long id) {
        habilidadRepository.deleteById(id);
    }
}
