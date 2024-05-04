package Grupo6.VoluntariadoEmergencias.entities;

import org.locationtech.jts.geom.Geometry;

public class VoluntarioEntity {

    private Long idVoluntario;
    private String nombre;
    private String email;
    private String password;
    private String rut;
    private Double longitud_voluntario;
    private Double latitud_voluntario;

    public VoluntarioEntity(Long id, String nombre, String email, String password, String rut, Double longitud_voluntario, Double latitud_voluntario) {
        this.idVoluntario = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rut = rut;
        this.longitud_voluntario = longitud_voluntario;
        this.latitud_voluntario = latitud_voluntario;
    }

    public Long getId() {
        return idVoluntario;
    }

    public void setId(Long id) {
        this.idVoluntario = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Double getLongitud_voluntario() {
        return longitud_voluntario;
    }

    public void setLongitud_voluntario(Double longitud_voluntario) {
        this.longitud_voluntario = longitud_voluntario;
    }

    public Double getLatitud_voluntario() {
        return latitud_voluntario;
    }

    public void setLatidud_voluntario(Double latitud_voluntario) {
        this.latitud_voluntario = latitud_voluntario;
    }
}
