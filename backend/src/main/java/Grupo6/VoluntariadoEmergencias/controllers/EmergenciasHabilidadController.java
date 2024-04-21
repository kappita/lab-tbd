package Grupo6.VoluntariadoEmergencias.controllers;

import org.springframework.web.bind.annotation.*;
import Grupo6.VoluntariadoEmergencias.entities.EmergenciasHabilidadEntity;
import Grupo6.VoluntariadoEmergencias.services.EmergenciasHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class EmergenciasHabilidadController {

    @Autowired
    EmergenciasHabilidadService emergenciasHabilidadService;

    @GetMapping("/emergencias_habilidad/getEmergencias")
    @ResponseBody
    public List<EmergenciasHabilidadEntity> getEmergenciasHabilidad(){
        return emergenciasHabilidadService.obtenerEmergenciasHabilidad();
    }
}
