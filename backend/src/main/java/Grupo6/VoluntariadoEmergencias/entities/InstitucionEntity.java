package Grupo6.VoluntariadoEmergencias.entities;

public class InstitucionEntity {
    private Long idInstitucion;
    private String nombre;

    public InstitucionEntity(Long id, String nombre) {
        this.idInstitucion = id;
        this.nombre = nombre;
    }
    public Long getId() {
        return idInstitucion;
    }

    public void setId(Long id) {
        this.idInstitucion = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
