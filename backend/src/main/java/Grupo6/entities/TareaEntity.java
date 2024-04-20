package Grupo6.entities;

public class TareaEntity {

    private Long idTarea;
    private Long idEmergencia;
    private String nombre;
    private String estado;

    public TareaEntity(Long idTarea, Long idEmergencia, String nombre, String estado) {
        this.idTarea = idTarea;
        this.idEmergencia = idEmergencia;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
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
