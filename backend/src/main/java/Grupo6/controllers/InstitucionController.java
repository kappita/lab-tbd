package Grupo6.controllers;

import Grupo6.entities.InstitucionEntity;
import Grupo6.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instituciones")
@CrossOrigin("*")
public class InstitucionController {

    @Autowired
    InstitucionService institucionService;

    @GetMapping("/")
    public ResponseEntity<List<InstitucionEntity>> listInstitucions() {
        List<InstitucionEntity> institucions = institucionService.getAllInstitucions();
        return ResponseEntity.ok(institucions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitucionEntity> getInstitucionById(@PathVariable Long id) {
        InstitucionEntity institucion = institucionService.getInstitucionById(id);
        return ResponseEntity.ok(institucion);
    }

    @PostMapping("/")
    public ResponseEntity<InstitucionEntity> saveInstitucion(@RequestBody InstitucionEntity institucion) {
        InstitucionEntity institucionNueva = institucionService.crearInstitucion(institucion);
        return ResponseEntity.ok(institucionNueva);
    }

    @PutMapping("/")
    public ResponseEntity<InstitucionEntity> updateInstitucion(@RequestBody InstitucionEntity institucion){
        InstitucionEntity institucionActualizada = institucionService.updateInstitucion(institucion);
        return ResponseEntity.ok(institucionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInstitucionById(@PathVariable Long id) throws Exception {
        Boolean isDeleted = institucionService.deleteInstitucion(id);
        return ResponseEntity.noContent().build();
    }
}
