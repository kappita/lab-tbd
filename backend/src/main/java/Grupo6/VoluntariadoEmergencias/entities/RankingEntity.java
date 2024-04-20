package Grupo6.VoluntariadoEmergencias.entities;

public class RankingEntity {


    private Long idRanking;
    private Long idVoluntario;
    private Long idTarea;
    private int ranking;

    public RankingEntity(Long id, Long id_voluntario, Long id_tarea, int ranking) {
        this.idRanking = id;
        this.idVoluntario = id_voluntario;
        this.idTarea = id_tarea;
        this.ranking = ranking;
    }

    public Long getId() {
        return idRanking;
    }

    public void setId(Long idRanking) {
        this.idRanking = idRanking;
    }

    public Long getId_Voluntario() {
        return idVoluntario;
    }

    public void setId_Voluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getId_Tarea() {
        return idTarea;
    }

    public void setId_Tarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

}
