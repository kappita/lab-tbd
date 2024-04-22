package Grupo6.VoluntariadoEmergencias.entities;

public class VoluntarioHabilidadEntity {
    private Long voluntarioHabilidadId;
    private Long idVoluntario;
    private Long idHabilidad;

    public VoluntarioHabilidadEntity(Long id, Long id_voluntario, Long id_habilidad) {
        this.voluntarioHabilidadId = id;
        this.idVoluntario = id_voluntario;
        this.idHabilidad = id_habilidad;
    }

    public Long getId() {
        return voluntarioHabilidadId;
    }

    public void setId(Long habilidadId) {
        this.voluntarioHabilidadId = habilidadId;
    }

    public Long getId_Voluntario() {
        return idVoluntario;
    }

    public void setId_Voluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getId_Habilidad() {
        return idHabilidad;
    }

    public void setId_Habilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

}
