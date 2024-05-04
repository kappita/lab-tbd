package Grupo6.VoluntariadoEmergencias.entities;

import org.locationtech.jts.geom.Geometry;

public class EmergenciaEntity {
    private Long idEmergencia;
    private Long idInstitucion;
    private String nombre;
    private boolean activa;
    private Double longitud_emergencia;
    private Double latitud_emergencia;

    public EmergenciaEntity(Long id, Long id_institucion, String nombre, boolean activa, Double longitud_emergencia, Double latitud_emergencia){
        this.idEmergencia = id;
        this.idInstitucion = id_institucion;
        this.nombre = nombre;
        this.activa = activa;
        this.longitud_emergencia = longitud_emergencia;
        this.latitud_emergencia = latitud_emergencia;
    }

    public Long getId() { return idEmergencia;}

    public void setId(Long idEmergencia) { this.idEmergencia = idEmergencia;}

    public Long getId_Institucion() { return idInstitucion;}

    public void setId_Institucion(Long idInstitucion) { this.idInstitucion = idInstitucion;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean getActiva(){return activa; }

    public void setActiva(boolean newActiva){this.activa=newActiva; }

    public Double getLongitud_emergencia() {
        return longitud_emergencia;
    }

    public void setLongitud_emergencia(Double longitud_emergencia) {
        this.longitud_emergencia = longitud_emergencia;
    }

    public Double getLatitud_emergencia() {
        return latitud_emergencia;
    }

    public void setLatidud_emergencia(Double latidud_emergencia) {
        this.latitud_emergencia = latidud_emergencia;
    }
}

