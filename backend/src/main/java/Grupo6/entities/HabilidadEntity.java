package Grupo6.entities;

public class HabilidadEntity {

    private Long habilidadId;
    private String nombre;
    private String descripcion;

    public HabilidadEntity(Long habilidadId, String nombre, String descripcion) {
        this.habilidadId = habilidadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Long habilidadId) {
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
