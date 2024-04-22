package Grupo6.VoluntariadoEmergencias.entities;

public class EmeHabilidadEntity {
    private Long idEmeHabilidad;
    private Long idEmergencia;
    private Long idHabilidad;

    public EmeHabilidadEntity(Long id, Long id_emergencia,Long id_habilidad) {
        this.idEmeHabilidad = id;
        this.idEmergencia = id_emergencia;
        this.idHabilidad = id_habilidad;
    }
    public Long getId() {
        return idEmeHabilidad;
    }

    public void setId(Long id) {
        this.idEmeHabilidad = id;
    }

    public Long getId_Emergencia() {
        return idEmergencia;
    }

    public void setId_Emergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public Long getId_Habilidad() {
        return idHabilidad;
    }

    public void setId_Habilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }


}
