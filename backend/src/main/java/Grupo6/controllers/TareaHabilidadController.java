package Grupo6.controllers;

import Grupo6.entities.TareaHabilidadEntity;
import Grupo6.services.TareaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareasHabilidad")
@CrossOrigin("*")
public class TareaHabilidadController {
    @Autowired
    TareaHabilidadService tareaHabilidadService;

    @GetMapping("/")
    public ResponseEntity<List<TareaHabilidadEntity>> listTareasHabilidad() {
        List<TareaHabilidadEntity> tareasHabilidad = tareaHabilidadService.getTareasHabilidad();
        return ResponseEntity.ok(tareasHabilidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaHabilidadEntity> getTareaHabilidadById(@PathVariable Long id) {
        TareaHabilidadEntity tareaHabilidad = tareaHabilidadService.getTareaHabilidadByIdTareaHabilidad(id);
        return ResponseEntity.ok(tareaHabilidad);
    }

    @PostMapping("/")
    public ResponseEntity<TareaHabilidadEntity> saveTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad) {
        TareaHabilidadEntity tareaHabilidadNueva = tareaHabilidadService.saveTareaHabilidad(tareaHabilidad);
        return ResponseEntity.ok(tareaHabilidadNueva);
    }

    @PutMapping("/")
    public ResponseEntity<TareaHabilidadEntity> updateTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad){
        TareaHabilidadEntity tareaHabilidadActualizada = tareaHabilidadService.updateTareaHabilidad(tareaHabilidad);
        return ResponseEntity.ok(tareaHabilidadActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTareaHabilidadById(@PathVariable Long id) throws Exception {
        var isDeleted = tareaHabilidadService.deleteTareaHabilidad(id);
        return ResponseEntity.noContent().build();
    }

}

