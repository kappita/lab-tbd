package Grupo6.controllers;

import Grupo6.entities.HabilidadEntity;
import Grupo6.repositories.HabilidadRepository;
import Grupo6.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/habilidades")
@CrossOrigin
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    public ResponseEntity<List<HabilidadEntity>> getAllHabilidades() {
        List<HabilidadEntity> response = habilidadService.findAllHabilidades();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<HabilidadEntity> getHabilidadById(Long id) {
        HabilidadEntity response = habilidadService.findHabilidadById(id);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<HabilidadEntity> saveHabilidad(HabilidadEntity habilidad) {
        HabilidadEntity response = habilidadService.saveHabilidad(habilidad);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<HabilidadEntity> updateHabilidad(HabilidadEntity habilidad) {
        HabilidadEntity response = habilidadService.updateHabilidad(habilidad);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<HabilidadEntity> deleteHabilidad(Long id) {
        habilidadService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
