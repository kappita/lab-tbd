package Grupo6.VoluntariadoEmergencias.dto;

import Grupo6.VoluntariadoEmergencias.entities.UsuariosEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicResp {

    private int codigoStatus;
    private String error;
    private String mensaje;
    private String token;
    private String tokenActualizado;
    private String tExpiracion;
    private String nombre;
    private String email;
    private String rol;
    private String contrasena;
    private UsuariosEntity Usuarios;

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(int codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenActualizado() {
        return tokenActualizado;
    }

    public void setTokenActualizado(String tokenActualizado) {
        this.tokenActualizado = tokenActualizado;
    }

    public String gettExpiracion() {
        return tExpiracion;
    }

    public void settExpiracion(String tExpiracion) {
        this.tExpiracion = tExpiracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuariosEntity getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(UsuariosEntity usuarios) {
        Usuarios = usuarios;
    }
}
