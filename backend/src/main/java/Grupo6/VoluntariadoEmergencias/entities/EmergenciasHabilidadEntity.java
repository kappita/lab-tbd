package Grupo6.VoluntariadoEmergencias.entities;

public class EmergenciasHabilidadEntity {
    private Long id_emergencia;
    private String nombre_emergencia;
    private String nombre_habilidad;

    public EmergenciasHabilidadEntity(Long id_emergencia, String nombre_emergencia, String nombre_habilidad) {
        this.id_emergencia = id_emergencia;
        this.nombre_emergencia = nombre_emergencia;
        this.nombre_habilidad = nombre_habilidad;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public String getNombre_emergencia() {
        return nombre_emergencia;
    }

    public void setNombre_emergencia(String nombre_emergencia) {
        this.nombre_emergencia = nombre_emergencia;
    }

    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }
}
