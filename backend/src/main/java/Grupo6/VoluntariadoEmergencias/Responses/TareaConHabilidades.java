package Grupo6.VoluntariadoEmergencias.Responses;

import Grupo6.VoluntariadoEmergencias.entities.TareaEmergenciaEntity;

import java.util.ArrayList;
import java.util.List;

public class TareaConHabilidades {
    private Long idEmergencia;
    private String nombreEmergencia;
    private Long idTarea;
    private String nombreTarea;
    private List<String> habilidades;

    public TareaConHabilidades(Long idEmergencia, String nombreEmergencia, Long idTarea, String nombreTarea) {
        this.idEmergencia = idEmergencia;
        this.nombreEmergencia = nombreEmergencia;
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.habilidades = new ArrayList<>();
    }

    public TareaConHabilidades(TareaEmergenciaEntity tareaEmergenciaEntity) {
        this.idEmergencia = tareaEmergenciaEntity.getIdEmergencia();
        this.nombreEmergencia = tareaEmergenciaEntity.getNombreEmergencia();
        this.idTarea = tareaEmergenciaEntity.getIdTarea();
        this.nombreTarea = tareaEmergenciaEntity.getNombre_tarea();
        this.habilidades = new ArrayList<>();
    }

    public void appendHabilidad(String habilidad) {
        this.habilidades.add(habilidad);
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

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
