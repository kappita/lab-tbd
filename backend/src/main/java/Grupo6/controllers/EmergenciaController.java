package Grupo6.controllers;

import Grupo6.entities.EmergenciaEntity;
import Grupo6.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emergencias")
@CrossOrigin("*")
public class EmergenciaController {

    @Autowired
    EmergenciaService emergenciaService;

    @GetMapping("/")
    public ResponseEntity<List<EmergenciaEntity>>listEmergencias() {
        List<EmergenciaEntity> emergencias = emergenciaService.getEmergencia();
        return ResponseEntity.ok(emergencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergenciaEntity> getEmergenciaById(@PathVariable Long id) {
        EmergenciaEntity emergencia = emergenciaService.getEmergenciaByIdEmergencia(id);
        return ResponseEntity.ok(emergencia);
    }

    @PostMapping("/")
    public ResponseEntity<EmergenciaEntity> saveEmergencia(@RequestBody EmergenciaEntity emergencia) {
        EmergenciaEntity emergenciaNueva = emergenciaService.saveEmergencia(emergencia);
        return ResponseEntity.ok(emergenciaNueva);
    }

    @PutMapping("/")
    public ResponseEntity<EmergenciaEntity> updateEmergencia(@RequestBody EmergenciaEntity emergencia){
        EmergenciaEntity emergenciaActualizada = emergenciaService.updateEmergencia(emergencia);
        return ResponseEntity.ok(emergenciaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmergenciaById(@PathVariable Long id) throws Exception {
        var isDeleted = emergenciaService.deleteEmergencia(id);
        return ResponseEntity.noContent().build();
    }

}

