package Grupo6.VoluntariadoEmergencias.controllers;

import org.springframework.web.bind.annotation.*;
import Grupo6.VoluntariadoEmergencias.services.AgregarVoluntarioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AgregarVoluntarioDisponibleController {

    @Autowired
    AgregarVoluntarioDisponibleService agregarVoluntarioDisponibleService;

    @PostMapping("/agregar_voluntario_disponible/{idEmergencia}/{emailVoluntario}")
    public String postularComoDisponible(@PathVariable int idEmergencia, @PathVariable String emailVoluntario) {
        agregarVoluntarioDisponibleService.postularComoDisponible(idEmergencia, emailVoluntario);
        return "Voluntario registrado como disponible para la emergencia";
    }
}
