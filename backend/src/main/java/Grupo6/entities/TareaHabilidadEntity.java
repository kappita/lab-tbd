package Grupo6.entities;

public class TareaHabilidadEntity {

    private Long idTareaHab;
    private Long idTarea;
    private Long habilidadId;

    public TareaHabilidadEntity (Long idTareaHab, Long idTarea, Long habilidadId){
        this.idTareaHab = idTareaHab;
        this.idTarea = idTarea;
        this.habilidadId = habilidadId;
    }

    public Long getIdTareaHab() {
        return idTareaHab;
    }

    public void setIdTareaHab(Long idTareaHab) {
        this.idTareaHab = idTareaHab;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Long habilidadId) {
        this.habilidadId = habilidadId;
    }
}

