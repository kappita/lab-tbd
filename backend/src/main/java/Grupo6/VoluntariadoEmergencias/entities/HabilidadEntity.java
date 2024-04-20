package Grupo6.VoluntariadoEmergencias.entities;

public class HabilidadEntity {

    private Long habilidadId;
    private String nombre;
    private String descripcion;

    public HabilidadEntity(Long id, String nombre, String descripcion) {
        this.habilidadId = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return habilidadId;
    }

    public void setId(Long habilidadId) {
        this.habilidadId = habilidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
