package Grupo6.VoluntariadoEmergencias.entities;

public class TareaHabilidadEntity {

    private Long idTareaHab;
    private Long idTarea;
    private Long habilidadId;

    public TareaHabilidadEntity (Long id, Long id_tarea, Long id_habilidad){
        this.idTareaHab = id;
        this.idTarea = id_tarea;
        this.habilidadId = id_habilidad;
    }

    public Long getId() {
        return idTareaHab;
    }

    public void setId(Long idTareaHab) {
        this.idTareaHab = idTareaHab;
    }

    public Long getId_Tarea() {
        return idTarea;
    }

    public void setId_Tarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getId_Habilidad() {
        return habilidadId;
    }

    public void setId_Habilidad(Long habilidadId) {
        this.habilidadId = habilidadId;
    }
}

