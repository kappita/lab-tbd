package Grupo6.controllers;

import Grupo6.entities.VoluntarioEntity;
import Grupo6.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voluntarios")
@CrossOrigin("*")
public class VoluntarioController {

    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping("/")
    public ResponseEntity<List<VoluntarioEntity>> listVoluntarios() {
        List<VoluntarioEntity> voluntarios = voluntarioService.getVoluntarios();
        return ResponseEntity.ok(voluntarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioEntity> getVoluntarioById(@PathVariable Long id) {
        VoluntarioEntity voluntario = voluntarioService.getVoluntarioById(id);
        return ResponseEntity.ok(voluntario);
    }

    @PostMapping("/")
    public ResponseEntity<VoluntarioEntity> saveVoluntario(@RequestBody VoluntarioEntity voluntario) {
        VoluntarioEntity voluntarioNuevo = voluntarioService.saveVoluntario(voluntario);
        return ResponseEntity.ok(voluntarioNuevo);
    }

    @PutMapping("/")
    public ResponseEntity<VoluntarioEntity> updateVoluntario(@RequestBody VoluntarioEntity voluntario){
        VoluntarioEntity voluntarioActualizado = voluntarioService.updateVoluntario(voluntario);
        return ResponseEntity.ok(voluntarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVoluntarioById(@PathVariable Long id) throws Exception {
        var isDeleted = voluntarioService.deleteVoluntario(id);
        return ResponseEntity.noContent().build();
    }
}
