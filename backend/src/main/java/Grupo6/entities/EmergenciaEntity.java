package Grupo6.entities;

public class EmergenciaEntity {
    private Long idEmergencia;
    private Long idInstitucion;
    private String nombre;

    public EmergenciaEntity(Long idEmergencia, Long idInstitucion, String nombre){
        this.idEmergencia = idEmergencia;
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
    }

    public Long getIdEmergencia() { return idEmergencia;}

    public void setIdEmergencia(Long idEmergencia) { this.idEmergencia = idEmergencia;}

    public Long getIdInstitucion() { return idInstitucion;}

    public void setIdInstitucion(Long idInstitucion) { this.idInstitucion = idInstitucion;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre; }
}

