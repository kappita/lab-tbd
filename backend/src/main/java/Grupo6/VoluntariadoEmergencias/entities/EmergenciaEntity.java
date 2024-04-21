package Grupo6.VoluntariadoEmergencias.entities;

public class EmergenciaEntity {
    private Long idEmergencia;
    private Long idInstitucion;
    private String nombre;
    private boolean activa;

    public EmergenciaEntity(Long id, Long id_institucion, String nombre, boolean activa){
        this.idEmergencia = id;
        this.idInstitucion = id_institucion;
        this.nombre = nombre;
        this.activa = activa;

    }

    public Long getId() { return idEmergencia;}

    public void setId(Long idEmergencia) { this.idEmergencia = idEmergencia;}

    public Long getId_Institucion() { return idInstitucion;}

    public void setId_Institucion(Long idInstitucion) { this.idInstitucion = idInstitucion;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean getActiva(){return activa; }

    public void setActiva(boolean newActiva){this.activa=newActiva; }



}

