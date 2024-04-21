package Grupo6.VoluntariadoEmergencias.entities;

public class TareaEmergenciaEntity {
    private Long id_emergencia;
    private String nombre_emergencia;
    private Long id_tarea;
    private String nombre_tarea;
    private Long id_habilidad;
    private String nombre_habilidad;

    public TareaEmergenciaEntity(Long idEmergencia,
                                 String nombreEmergencia,
                                 Long idTarea,
                                 String nombreTarea,
                                 String habilidad) {

        this.id_emergencia = idEmergencia;
        this.nombre_emergencia = nombreEmergencia;
        this.id_tarea = idTarea;
        this.nombre_tarea = nombreTarea;
        this.nombre_habilidad = habilidad;
    }

    public Long getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.id_emergencia = idEmergencia;
    }

    public String getNombreEmergencia() {
        return nombre_emergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombre_emergencia = nombreEmergencia;
    }

    public Long getIdTarea() {
        return id_tarea;
    }

    public void setIdTarea(Long idTarea) {
        this.id_tarea = idTarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public Long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    public void setNombre_habilidad(String habilidad) {
        this.nombre_habilidad = habilidad;
    }
}
