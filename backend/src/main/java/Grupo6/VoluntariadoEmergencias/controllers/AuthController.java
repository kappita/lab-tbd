package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.dto.SolicResp;
import Grupo6.VoluntariadoEmergencias.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SolicResp> registrar(@RequestBody SolicResp solRegistro){
        return ResponseEntity.ok(authService.registrar(solRegistro));
    }

    @PostMapping("/signin")
    public ResponseEntity<SolicResp> ingresar(@RequestBody SolicResp solIngreso){
        return ResponseEntity.ok(authService.ingresar(solIngreso));
    }

    @PostMapping("/refresh")
    public ResponseEntity<SolicResp> actualizarToken(@RequestBody SolicResp solActToken){
        return ResponseEntity.ok(authService.actualizarToken(solActToken));
    }
}
