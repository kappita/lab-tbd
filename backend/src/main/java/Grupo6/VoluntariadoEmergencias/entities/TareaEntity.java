package Grupo6.VoluntariadoEmergencias.entities;

public class TareaEntity {

    private Long idTarea;
    private Long idEmergencia;
    private String nombre;
    private String estado;

    public TareaEntity(Long id, Long id_emergencia, String nombre, String estado) {
        this.idTarea = id;
        this.idEmergencia = id_emergencia;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return idTarea;
    }

    public void setId(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getId_Emergencia() {
        return idEmergencia;
    }

    public void setId_Emergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
