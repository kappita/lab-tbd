package Grupo6.entities;

import java.util.List;

public class TareaEmergenciaEntity {
    private Long idEmergencia;
    private String nombreEmergencia;
    private Long idTarea;
    private String nombreTarea;
    private String habilidad;

    public TareaEmergenciaEntity(Long idEmergencia,
                                 String nombreEmergencia,
                                 Long idTarea,
                                 String nombreTarea,
                                 String habilidad) {

        this.idEmergencia = idEmergencia;
        this.nombreEmergencia = nombreEmergencia;
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.habilidad = habilidad;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidades(String habilidad) {
        this.habilidad = habilidad;
    }
}
