package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.dto.SolicResp;
import Grupo6.VoluntariadoEmergencias.entities.UsuariosEntity;
import Grupo6.VoluntariadoEmergencias.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder codificadorPass;
    @Autowired
    private AuthenticationManager authenticationManager;

    public SolicResp registrar(SolicResp solRegistro){
        SolicResp resp = new SolicResp();
        try{
            UsuariosEntity usuariosEntity = new UsuariosEntity();
            usuariosEntity.setEmail(solRegistro.getEmail());
            usuariosEntity.setPassword(codificadorPass.encode(solRegistro.getContrasena()));
            usuariosEntity.setRole(solRegistro.getRol());
            UsuariosEntity usuariosEntityRes = usuariosRepository.save(usuariosEntity);
            if (usuariosEntityRes != null && usuariosEntityRes.getId()>0){
                resp.setUsuarios(usuariosEntityRes);
                resp.setMensaje("Usuario creado exitosamente.");
                resp.setCodigoStatus(200);
            }
        }catch (Exception e){
            resp.setCodigoStatus(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public SolicResp ingresar(SolicResp solIngreso){
        SolicResp respuesta = new SolicResp();

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(solIngreso.getEmail(),solIngreso.getContrasena()));
            var usuario = usuariosRepository.getByEmail(solIngreso.getEmail()).orElseThrow();
            System.out.println("USUARIO:"+usuario);
            var jwt = jwtUtils.generarToken(usuario);
            var TokenActualizado = jwtUtils.generarTokenActualizado(new HashMap<>(),usuario);
            respuesta.setCodigoStatus(200);
            respuesta.setToken(jwt);
            respuesta.setTokenActualizado(TokenActualizado);
            respuesta.settExpiracion("24h.");
            respuesta.setMensaje("Ingreso exitoso.");
        }catch (Exception e){
            respuesta.setCodigoStatus(500);
            respuesta.setError(e.getMessage());
        }
        return respuesta;
    }

    public SolicResp actualizarToken(SolicResp solTokenActualizado) {

        SolicResp respuesta = new SolicResp();
        String email = jwtUtils.extraerUsername(solTokenActualizado.getToken());
        UsuariosEntity usuarios = usuariosRepository.getByEmail(email).orElseThrow();
        if (jwtUtils.TokenValido(solTokenActualizado.getToken(),usuarios)){
            var jwt = jwtUtils.generarToken(usuarios);
            respuesta.setCodigoStatus(200);
            respuesta.setToken(jwt);
            respuesta.setTokenActualizado(solTokenActualizado.getToken());
            respuesta.settExpiracion("24h.");
            respuesta.setMensaje("Token Actualizado Exitosamente.");
        }
        respuesta.setCodigoStatus(500);
        return respuesta;
    }
}
