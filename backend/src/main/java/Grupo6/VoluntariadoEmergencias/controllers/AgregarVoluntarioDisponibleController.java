package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.Forms.JoinEmergencyForm;
import org.springframework.web.bind.annotation.*;
import Grupo6.VoluntariadoEmergencias.services.AgregarVoluntarioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AgregarVoluntarioDisponibleController {

    @Autowired
    AgregarVoluntarioDisponibleService agregarVoluntarioDisponibleService;

    @PostMapping("/agregar_voluntario_disponible")
    public String postularComoDisponible(@RequestBody JoinEmergencyForm body) {
        agregarVoluntarioDisponibleService.postularComoDisponible(body);
        return "Voluntario registrado como disponible para la emergencia";
    }
}
