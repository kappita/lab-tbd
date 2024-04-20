package Grupo6.controllers;

import Grupo6.entities.TareaEntity;
import Grupo6.responses.TareaConHabilidades;
import Grupo6.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")
@CrossOrigin("*")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @GetMapping("/")
    public ResponseEntity<List<TareaEntity>> listTareas() {
        List<TareaEntity> tareas = tareaService.getTareas();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaEntity> getTareaById(@PathVariable Long id) {
        TareaEntity tarea = tareaService.getTareaByIdTarea(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping("/")
    public ResponseEntity<TareaEntity> saveTarea(@RequestBody TareaEntity tarea) {
        TareaEntity tareaNueva = tareaService.saveTarea(tarea);
        return ResponseEntity.ok(tareaNueva);
    }

    @PutMapping("/")
    public ResponseEntity<TareaEntity> updateTarea(@RequestBody TareaEntity tarea){
        TareaEntity tareaActualizada = tareaService.updateTarea(tarea);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTareaById(@PathVariable Long id) throws Exception {
        var isDeleted = tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<TareaConHabilidades>> getEligibleTareasByVoluntaryEmail(@PathVariable String email) {
        List<TareaConHabilidades> tareas = tareaService.findEligibleTareasByVoluntaryEmail(email);
        return ResponseEntity.ok(tareas);

    }
}
