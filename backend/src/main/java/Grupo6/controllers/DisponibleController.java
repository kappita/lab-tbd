package Grupo6.controllers;

import Grupo6.entities.DisponibleEntity;
import Grupo6.services.DisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voluntariosDisponibles")
@CrossOrigin("*")

public class DisponibleController {

    @Autowired
    DisponibleService disponibleService;

    @GetMapping("/")
    public ResponseEntity<List<DisponibleEntity>> listDisponibles() {
        List<DisponibleEntity> disponibles = disponibleService.getAllDisponibles();
        return ResponseEntity.ok(disponibles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisponibleEntity> getDisponibleById(@PathVariable Long id) {
        DisponibleEntity disponible = disponibleService.getDisponibleById(id);
        return ResponseEntity.ok(disponible);
    }

    @PostMapping("/")
    public ResponseEntity<DisponibleEntity> saveDisponible(@RequestBody DisponibleEntity disponible) {
        DisponibleEntity disponibleNueva = disponibleService.createDisponible(disponible);
        return ResponseEntity.ok(disponibleNueva);
    }

    @PutMapping("/")
    public ResponseEntity<DisponibleEntity> updateDisponible(@RequestBody DisponibleEntity disponible){
        DisponibleEntity disponibleActualizada = disponibleService.updateDisponible(disponible);
        return ResponseEntity.ok(disponibleActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDisponibleById(@PathVariable Long id) throws Exception {
        Boolean isDeleted = disponibleService.deleteDisponible(id);
        return ResponseEntity.noContent().build();
    }

}
